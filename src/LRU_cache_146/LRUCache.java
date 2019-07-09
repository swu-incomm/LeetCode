package LRU_cache_146;

import java.util.HashMap;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?


 */
public class LRUCache {

    private class DNode {
        int key;
        int value;
        DNode pre;
        DNode post;
    }

    private DNode head, tail;

    private HashMap<Integer, DNode> cache = new HashMap<Integer, DNode>();

    private int count;
    private int capacity;

    private void addNode(DNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode (DNode node) {
        DNode pre = node.pre;
        DNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void  moveToHead(DNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DNode popTail() {
        DNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DNode();
        tail = new DNode();

        head.pre = null;
        head.post = tail;
        tail.pre = head;
        tail.post = null;
    }

    public int get(int key) {
        DNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DNode node = cache.get(key);
        if(node == null) {
            DNode newNode = new DNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity) {
                DNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */