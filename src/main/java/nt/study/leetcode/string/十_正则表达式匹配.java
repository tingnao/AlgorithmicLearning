package nt.study.leetcode.string;

import java.util.Arrays;

public class 十_正则表达式匹配 {
    /**
     * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
       int sLen = s.length(), pLen = p.length();
       // 用来保存s和p匹配的状态
       boolean[][] statusList = new boolean[sLen + 1][pLen +  1];
       // statusList[0]这一行为初始状态量，除了[0][0]其他都为false
       statusList[0][0] = true;
       // 遍历得到所有的状态量
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                // 如果p中j-1这个位置字符为*，则这个字符的状态量与以下情况相关：
                // 1. 如果s中i-1这个位置的字符与p中j-2(*之前的字符）这个位置的字符相匹配，
                //    那么当前状态量与两个情况有关：
                //            1. s中[0, i-2]这个范围内的字符串是否与p中[0, j-1]这个范围内的字符串匹配，即statusList[i - 1][j]的值（进行 *'+'*'前一个字符 匹配）
                //            2. s中[0, i-1]这个范围内的字符串是否与p中[0, j-3]这个范围内的字符串匹配，即statusList[i][j - 2]的值（丢弃 '*'前一个字符+'*' 进行匹配）
                //      只要上述两个情况有一个匹配，那么当前状态量就为true，表示匹配
               if(p.charAt(j - 1) == '*'){
                   statusList[i][j] = statusList[i][j - 2];
                   if(matches(s, p, i, j - 1)){
                       statusList[i][j] = statusList[i - 1][j] || statusList[i][j - 2];
                   }
               }else{
                    // 否则看s中i-1位置字符与p中j-1字符是否匹配，匹配状态量就取决于s中[0, i-2]这个范围内的字符串与p中[0, j-2]这个范围内的字符串是否匹配,
                   // 即取决于statusList[i - 1][j - 1]的值
                   if(matches(s, p, i, j)){
                       statusList[i][j] = statusList[i - 1][j - 1];
                   }
               }
               if(i > 0 && j > 0){
                System.out.println(String.format("s中第%d个字符%s匹配p中第%d个的%s结果为：%s", i, s.charAt(i-1), j, p.charAt(j-1), statusList[i][j]));
               }
            }
        }
        return statusList[sLen][pLen];
    }

    public static boolean matches(String s, String p, int left, int right){
        // i == 0这一行都是用来初始化状态量的
        if(left == 0){
            return false;
        }
        if(p.charAt(right - 1) == '.'){
            return true;
        }
        return s.charAt(left - 1) == p.charAt(right - 1);
    }

    public static void main(String[] args) {
        String s = "jdkjfaksjd", p = "jdk.*jd";
        System.out.println(isMatch(s, p));
    }
}
