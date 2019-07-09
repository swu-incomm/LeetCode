package partition_equal_subset_sum_416;

import java.util.Arrays;
import java.util.HashMap;

/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two
subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.


Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Solution {
    public boolean canPartition(int[] nums) {

        if(nums == null || nums.length <=1) return false;
        int total = 0;

        for(int i = 0; i<nums.length; i++) total+=nums[i];
        if(total %2 != 0) return false;


        return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }

    //brute force with a lot of unnecessary recursive calls
    public boolean canPartition(int [] nums, int index, int sum, int total) {
        if(sum * 2 == total) return true;
        if(sum > total /2 || index >= nums.length) return false;
        //take the number or not take the number
        return canPartition(nums, index + 1, sum, total) || canPartition(nums, index +1, sum + nums[index], total);
    }

    //brute force with a lot of unnecessary recursive calls
    public boolean canPartition(int [] nums, int index, int sum, int total, HashMap<String, Boolean> state) {
        String current = index + "" + sum;
        if(state.containsKey(current)) {
            return state.get(current);
        }
        if(sum * 2 == total) return true;
        if(sum > total /2 || index >= nums.length) return false;

        boolean foundPartition = canPartition(nums, index + 1, sum, total, state) || canPartition(nums, index +1, sum + nums[index], total, state);

        state.put(current, foundPartition);

        return foundPartition;
    }

    //dp solution
    /*
    关键问题就是要找出状态转移方程了，我们需要遍历原数组中的数字，对于遍历到的每个数字nums[i]，需要更新dp数组，我们的最终目标是想知道dp[target]的boolean值，
    就要想办法用数组中的数字去凑出target，因为都是正数，所以只会越加越大，那么加上nums[i]就有可能会组成区间 [nums[i], target] 中的某个值，
    那么对于这个区间中的任意一个数字j，如果 dp[j - nums[i]] 为true的话，说明现在已经可以组成 j-nums[i] 这个数字了，再加上nums[i]，就可以组成数字j了，
    那么dp[j]就一定为true。如果之前dp[j]已经为true了，当然还要保持true，所以还要‘或’上自身，于是状态转移方程如下：

dp[j] = dp[j] || dp[j - nums[i]]         (nums[i] <= j <= target)

有了状态转移方程，那么我们就可以写出代码了，这里需要特别注意的是，第二个for循环一定要从target遍历到nums[i]，而不能反过来，想想为什么呢？
因为如果我们从nums[i]遍历到target的话，假如nums[i]=1的话，那么[1, target]中所有的dp值都是true，因为dp[0]是true，dp[1]会或上dp[0]，为true，
dp[2]会或上dp[1]，为true，依此类推，完全使我们的dp数组失效了
     */
    public boolean canPartitionDP(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        //dp[i] 表示原数组是否可以提取出若干个数字 使和组成为i
        for (int num : nums) {
            for (int j = sum; j > 0; j--) {
                if (j >= num) {
                    dp[j] = dp[j] || dp[j-num];
                }
            }
        }

        return dp[sum];
    }

}
