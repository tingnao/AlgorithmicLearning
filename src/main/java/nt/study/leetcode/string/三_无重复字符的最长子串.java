package nt.study.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class 三_无重复字符的最长子串 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串 的长度
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
     */

    public static  int lengthOfLongestSubstring(String s) {
        // 用于存储每个窗口下的非重复字符
        Set<Character> hashSet = new HashSet<>();
        // right以及left用于表示每个窗口的边界
        int right = -1, len = s.length(), max = 0;
        for (int left = 0; left < len; left ++) {
            // 如果left不等于0，就去掉上一个窗口的开始边界字符，再继续进行非重复字符匹配
            if(left != 0){
                hashSet.remove(s.charAt(left - 1));
            }
            // 窗口内非重复字符匹配
            while(right + 1 < len && !hashSet.contains(s.charAt(right + 1))){
                hashSet.add(s.charAt(right + 1));
                right ++;
            }
            // 取最大值
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "bbbbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
