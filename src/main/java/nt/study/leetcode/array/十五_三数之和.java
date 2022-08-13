package nt.study.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 十五_三数之和 {
    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        /** 使用排序 + 双指针 */
        List<List<Integer>> result = new ArrayList<>();
        int left = 0, right =  0, value = 0, len = nums.length;
        // 判断数组长度是否大于三
        if(len < 3){
            return result;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 如果排序之后第一个元素大于0或者最后一个元素小于0，直接返回，因为这样其中任意三个元素加起来必定不会等于0
        if(nums[0] > 0 || nums[len - 1] < 0){
            return result;
        }
        // 遍历数组
        for(int i = 0; i < len ; i++){
            // 取第一个元素并对其进行去重操作
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 第二个元素开始坐标为第一个元素的右边第一个，第三个元素开始坐标为最后一个元素，使用双指针找到合适的两个数，使得三者相加为0
            left = i + 1;
            right = len - 1;
            while(left < right){
                // 判断三者相加是否为0
                value = nums[i] + nums[left] + nums[right];
                // 如果相同就放入结果中
                if(value == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 因为要求三元组不重复，所以第二第三个元素不能重复，所以需要对第二个第三个元素进行去重
                    while(left < right && nums[left] == nums[left + 1]){
                        left ++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right --;
                    }
                    // 最后一个重复的元素->下一个不同的元素
                    left ++;
                    right --;
                }else if(value < 0){
                    // vlaue值小了，说明第二个元素小了
                    left ++;
                }else if(value > 0){
                    // vlaue值大了，说明第三个元素大了
                    right --;
                }
            }
        }
        return result;

    }




    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
