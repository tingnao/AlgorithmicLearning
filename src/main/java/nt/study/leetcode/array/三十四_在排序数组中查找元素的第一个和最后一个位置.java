package nt.study.leetcode.array;

import java.util.Arrays;

public class 三十四_在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     *
     * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length - 1, left = 0, right = len;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                left = mid - 1;
                right = mid + 1;
                // 找到符合条件的元素后在前方后方对其进行查找，得到第一个和最后一个
                while(left >=0 && nums[left] == target){
                    left --;
                }
                while(right <= len && nums[right] == target){
                    right ++;
                }
                return new int[]{++ left, --right};
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] squared = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.'){
                    int value = c - '0' - 1;
                    rows[i][value] ++;
                    columns[j][value] ++;
                    squared[i / 3][i / 3] ++;
                    if(rows[i][value] > 1 || columns[j][value] > 1 || squared[i / 3][j / 3] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
