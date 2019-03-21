package binarysearch;

public class ProblemB {
    //O(n) solution
    public boolean shiftedArrySearch(int arr [], int target) {
        for(int i : arr) {
            if (i == target) return true;
        }
        return false;
    }
    public static void main(String []args) {
        
    }
}
