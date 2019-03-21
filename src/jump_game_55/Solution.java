package jump_game_55;

public class Solution {
        public boolean canJump(int nums[]) {
            int max = 0;
            for(int i=0;i<nums.length;i++) {
                if(i > max) return false;
                max = Math.max(nums[i] + i, max);
            }
            return true;
        }
}

//Dp 做法， max保存从起点到当前点能走的最远下标，每次根据当前点能走的距离一步一步更新，一直到最后的下标
