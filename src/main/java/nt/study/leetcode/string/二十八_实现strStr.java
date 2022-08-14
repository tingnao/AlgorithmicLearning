package nt.study.leetcode.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 二十八_实现strStr {
    /**
     *实现strStr()函数。
     *
     * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     *
     * 说明：
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static int[] next;
    public static int strStr(String haystack, String needle) {
        if(needle == null){
            return 0;
        }
        int kmp = kmp(haystack, needle);
        return kmp;
    }

    public static int kmp(String haystack, String needle){
        getNext(needle);
        int left = 0, right =0;
        while(left < haystack.length() && right < needle.length()){
            if(right == -1 || haystack.charAt(left) == needle.charAt(right)){
                left ++;
                right ++;
            }else{
                right = next[right];
            }
        }
        if(right == needle.length()){
            return left - right;
        }else{
            return  -1;
        }
    }

    public static void getNext(String needle){
        int len = needle.length(), k = -1, index = 0;
        next = new int[len];
        next[0] = -1;
        while(index < len - 1){
            if(k == -1 || needle.charAt(k) == needle.charAt(index)){
                k ++;
                index ++;
                if(needle.charAt(index) == needle.charAt(k)){
                    next[index] = next[k];
                }else{
                    next[index] = k;
                }
            }else{
                k =  next[k];
            }
        }
    }

    public static void main(String[] args) {
        int i = strStr("hello", "ll");
        System.out.println(i);
    }
}
