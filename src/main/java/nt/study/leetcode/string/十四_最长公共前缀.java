package nt.study.leetcode.string;

public class 十四_最长公共前缀 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int size = 0, i = 0, len = strs.length;
        if(strs.length == 1){
            return strs[0];
        }
        boolean flag = true;
        while(flag){
            int j;
            for(j = 1; j < len; j++){
                if(i == strs[j].length() || i == strs[j-1].length() || strs[j].charAt(i) != strs[j - 1].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(j == len){
                size ++;
            }
            i++;
        }
        if(size == 0){
            return "";
        }else{
            return strs[0].substring(0, size);
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{""};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
