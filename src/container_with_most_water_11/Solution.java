package container_with_most_water_11;
/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


 */
public class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        if(height == null || height.length == 0) return ans;
        int left = 0, right = height.length-1;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if(area > ans) ans = area;
            if(height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }
        return ans;
    }
}
