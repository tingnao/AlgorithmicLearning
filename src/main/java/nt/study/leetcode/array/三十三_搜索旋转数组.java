package nt.study.leetcode.array;

import java.util.Arrays;

public class 三十三_搜索旋转数组 {
    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）
     * 。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int search(int[] nums, int target) {
        /**
         * 解法一、先找到翻转点，将其分割成为两个有序数组，再对其进行二分查找
         */
        int len = nums.length - 1, left = 0;
        while(left < len){
            if(nums[left] > nums[left + 1]){
                break;
            }
            left ++;
        }
        if(target < nums[0]){
            return binarySearch(nums, left + 1, len, target);
        }else if(target > nums[0]){
            return binarySearch(nums, 0, left, target);
        }else{
            return 0;
        }
    }

    public static int search2(int[] nums, int target) {
        /**
         * 解法二、直接进行二分查找
         */
        int len = nums.length - 1, left = 0, right = len,mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] > nums[len]){
            // mid左半部分为有序区域，右半区域可能有序可能无序
                if(target >= nums[0] && target < nums[mid]){
                    // 如果target在mid左边
                    right = mid - 1;
                }else{
                    //如果target在mid右边
                    left = mid + 1;
                }
            }else{
            // mid右半部分为有序区域，左半区域可能有序可能无序
                if(target > nums[mid] && target <= nums[len]){
                    // 如果target在mid右边
                    left = mid + 1;
                }else{
                    // 如果target在mid左边
                    right = mid -1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if(target == nums[mid]){
            return mid;
        }else if(target < nums[mid]){
            return binarySearch(nums, left, mid - 1, target);
        }else{
            return binarySearch(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(search2(nums, 0));
    }


}
