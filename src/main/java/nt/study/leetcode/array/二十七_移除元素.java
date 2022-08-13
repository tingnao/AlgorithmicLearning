package nt.study.leetcode.array;

import java.util.Arrays;

public class 二十七_移除元素 {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
     */
    public static  int removeElement(int[] nums, int val) {
        /** 双指针**/
        int index = 0, i = 0;
        while(i < nums.length){
            if(nums[i] != val){
                nums[index++] = nums[i++];
            }
        }
        return index;
    }

    public static int besetRemoveElement(int[] nums, int val){
        /**
         * 优化后的双指针，避免元素重复移动
         */
        int left = 0, right = nums.length ;
        while(left < right){
            if(nums[left] == val){
                nums[left] = nums[--right];
            }else{
                left ++;
            }
        }
        return left;
    }



    public static void swap(int[]nums, int i, int index){
        if(i == index){
            return;
        }
        nums[i] = nums[i] ^ nums[index];
        nums[index] = nums[i] ^ nums[index];
        nums[i] = nums[i] ^ nums[index];
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2};
        int i = removeElement(nums, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
