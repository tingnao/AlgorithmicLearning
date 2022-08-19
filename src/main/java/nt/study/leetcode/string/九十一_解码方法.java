package nt.study.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class 九十一_解码方法 {
    /**
     * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
     *
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     *
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     *
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     *
     * 题目数据保证答案肯定是一个 32 位 的整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/decode-ways
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static int numDecodings(String s) {
        return mapperCount(s);
    }

    public  static int mapperCount(String s){
        if(s.charAt(0) == '0'){
            return 0;
        }
        int len = s.length(), value, minValue;
        if(len == 1){
            return 1;
        }
        int left = 0, right = 0;
        minValue = Integer.parseInt(s.charAt(0)+"");
        if(minValue != 0){
            left = mapperCount(s.substring(1));

        }else{
            return 0;
        }
        value = Integer.parseInt(s.substring(0, 2));
        if(value <= 26){
            if(len == 2){
                right = 1;
            }
            else{
                right = mapperCount((s.substring(2)));
            }
        }
        return left + right;

    }

    public static void main(String[] args) {
        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
    }
}
