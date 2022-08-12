package nt.study.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 十八_四数之和 {
    /**
     * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public static  List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> arrayList = new ArrayList<>();
        int left = 0, right = 0, len = nums.length;
        long demoTarget = (long) target;
        long value = 0;
        // 寻找第一个元素，并对其进行去重
        for(int i = 0; i< len; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 寻找第二个元素对其进行去重
            for(int j = i + 1; j < len ; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                // 寻找第三个元素和第四个元素，从左边开始和从右边开始，使用双指针
                left = j + 1;
                right = len - 1;
                while(left < right){
                    // 判断值是否相等
                    value = demoTarget - nums[i] - nums[j] - nums[left] - nums[right];
                    if(value == 0){
                        // 相等加入到四元组集合中
                        arrayList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对第三个第四个元素进行去重操作、避免无效的比较
                        while(left < right && nums[left] == nums[left + 1]){
                            left ++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right --;
                        }
                        left ++;
                        right --;
                    }else if(value > 0){
                        // 如果小于，说明第三个元素过小，第三个元素的指针往右移
                        left ++;
                    }else{
                        // 否则第四个元素太大，第四个元素的指针往左移
                        right --;
                    }
                }
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lists = fourSum(nums, -294967296);
        System.out.println(lists);
    }
}
