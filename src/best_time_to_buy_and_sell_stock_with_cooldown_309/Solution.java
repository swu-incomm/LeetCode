package best_time_to_buy_and_sell_stock_with_cooldown_309;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one
share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

two states:
hold[i]
unhold[i]

result unhold[n-1]

init:
hold[0] = -prices[0]
hold[1] = Math.max(-prices[0], -prices[1])
unhold[0] = 0

state transfer:

hold[i] = Math.max(unhold[i-2] - prices[i], hold[i-1])
unhold[i] = Math.max(hold[i-1] + prices[i], unhold[i-1])
 */
public class Solution {
    //O(n) space complexity
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length <= 1) return 0;

        int len = prices.length;

        int [] hold = new int [len];
        int [] unhold = new int[len];

        hold[0] = -prices[0];
        hold[1] = Math.max(-prices[0], -prices[1]);
        unhold[0] = 0;
        unhold[1] = Math.max(0, prices[1] - prices[0]);

        for(int i = 2; i<len;i++) {
                hold[i] = Math.max(unhold[i-2] - prices[i], hold[i-1]);
                unhold[i] = Math.max(hold[i-1] + prices[i], unhold[i-1]);
        }

        return unhold[len - 1];
    }
}
