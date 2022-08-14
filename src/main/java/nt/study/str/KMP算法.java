package nt.study.str;

import java.util.Arrays;

public class KMP算法 {
    // s为目标字符串，m为待匹配字符串
    public int kmp(String s, String m){
        // j为待匹配字符串中两者匹配的长度 i为目标字符串中两者匹配的长度
        int i = 0, j = 0;
        int[] next = new int[Math.max(s.length(), m.length())];
        // 获取next数组
        getNext(next, m);
        // 判断是否超过了字符串的长度
        while(i < s.length() && j < m.length() ){
            // 如果j的值为next数组的第一个值或者两个字符串字符相同
            if(j == -1 || s.charAt(i) == m.charAt(j)){
                // 自增
                i++;
                j++;
            } else
                // 否则待匹配字符串匹配长度回溯到当前匹配长度在next数组中存放的对称长度
                j = next[j];
        }
        // 匹配成功
        if(j == m.length()){
            return (i - j);
        }else{
            // 匹配失败
            return -1;
        }
    }

    private static void getNext(int[] next, String m) {
        // next数组首位置-1
        next[0] = -1;
        // j表示后指针，k的值表示字符串m前j个字符中（0~k-1)范围内的字符与(j-k, j-1)相等，当m中第i个字符不匹配时，可以通过回溯到第k个位置继续进行匹配，避免了重复比较
        int j = 0, k = -1;
        // 未越界循环
        while(j < m.length() - 1){
            // 如果j的值为next数组的第一个值或者在next数组中
            if(k == -1 || m.charAt(j) == m.charAt(k)){
                j++;
                k++;
                next[j] = k;
            }
            else k = next[k];
        }

        System.out.println(Arrays.toString(next));
    }

    public static void main(String[] args) {
        int[] next = new int[5];
        String str = "ababc";
        getNext(next, str);
    }
}
