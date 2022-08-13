package nt.study.leetcode.array;

import java.util.Arrays;


public class 三十一_下一个排列 {
    /**
     * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
     * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列
     *
     */
    public static void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }
        int  right = 0, left = nums.length - 2;
        while(left >= 0 &&nums[left] >= nums[left + 1]){
            left --;
        };
        if(left == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        reverse(nums, left + 1, nums.length - 1);
        for(int i = left + 1; i< nums.length; i++){
            if(nums[left] < nums[i]){
                right = i;
                break;
            }
        }
        swap(nums, left, right == 0 ? left + 1 : right);
    }

    /**
     * 以序列{1,3,2}为例，查找下一个序列的过程为先找到第一个非逆序排列的元素，即1，
     * 然后再从后面的逆序数组中找到第一个比非逆序排列元素大的元素，即2，将两者交换，得到{2,3,1},
     * 将后面的逆序数组反转，得到下一个排列{2,1,3}
     *
     * @param nums
     */
    public static void newNextPermutation(int[] nums){
        int i = nums.length - 2;
        // 从后向前找到第一个非逆序排列的元素，这个就是待改变的元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果该元素大于等于0，说明当前这个排列不是全逆序的
        if (i >= 0) {
            // 从后面的逆序中找到比第一个非逆序元素稍大的元素，将其两者进行交换
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 将后面的逆序排列的元素变为正序排列，得到最终的结果
        reverse(nums, i + 1, nums.length - 1);
    }



    public static void swap(int[] nums, int left, int right){
        if(left == right){
            return;
        }
        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }


    public static void reverse(int[] nums, int i, int j){
        if(j - i < 1){
            return;
        }
        int left = i, right = j;
        while (left < right){
            swap(nums, left++, right--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
//        nextPermutation(nums);
        newNextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
