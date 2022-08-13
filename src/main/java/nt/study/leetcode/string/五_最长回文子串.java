package nt.study.leetcode.string;

public class 五_最长回文子串 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * @param s
     * @return
     */
    public static  String longestPalindrome(String s){
        String str = "";
        int temp = 0, temp2, max = 0;
        // 遍历字符串，i下标字符作为回文串的开头字符
        for(int left = 0; left < s.length(); left ++){
            int right = s.length() - 1;
            // right从后往前扫,找区域内的回文串
            while(left <= right){
                // 如果当前字符等于开头字符
                if(s.charAt(left) == s.charAt(right)){
                    // 进行回文串判断
                    temp = left;
                    temp2 = right;
                    while(temp < temp2){
                        if( s.charAt(temp) != s.charAt(temp2)){
                            break;
                        }
                        temp ++;
                        temp2 --;
                    }
                    // 如果当前字符串为回文串，判断是否比之前存储的最大回文串更长，如果是，进行存储
                    if(temp >= temp2 ){
                        if((right - left + 1) > max){
                            str = s.substring(left, right + 1);
                            max = Math.max(max, right - left + 1);
                        }
                        // 跳出当前while循环，因为当前回文串肯定是当前循环里能找到的最长回文串
                        break;
                    }
                }
                right --;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "abbabcba";
        System.out.println(longestPalindrome(str));
    }
}
