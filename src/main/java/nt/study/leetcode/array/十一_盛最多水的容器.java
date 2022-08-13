package nt.study.leetcode.array;

public class 十一_盛最多水的容器 {
    /**
     * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
     * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     */

    public static int maxArea(int[] height) {
        // 使用双指针解决
        int max = 0;
        int left = 0, right = height.length - 1, value;
        while(left <= right){
            value = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(value, max);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxValue = maxArea(height);
        System.out.println(maxValue);
    }
}
