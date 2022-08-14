package nt.study.leetcode.string;

import java.util.HashMap;

public class 十三_罗马数字转整数 {
    public static int romanToInt(String s) {
        int len = s.length(), left = 0, value = 0;
        HashMap hashMap = new HashMap(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        while(left < len){
            char c = s.charAt(left);
            if(left < len - 1 && (int)hashMap.get(s.charAt(left)) < (int)hashMap.get(s.charAt(left + 1))){
                value -= (int)hashMap.get(s.charAt(left));
            }else{
                value += (int)hashMap.get(s.charAt(left));
            }
            left ++;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
