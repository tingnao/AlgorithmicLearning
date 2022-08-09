package nt.study.str;

import java.util.Arrays;

public class 优化后的KMP算法 {
    public int[] nextVal;

    public int KMP(String s, String m){
        nextVal = new int[m.length()];
        // j为待匹配字符串中两者匹配的长度 i为目标字符串中两者匹配的长度
        int i = 0, j = 0;
        int[] next = new int[Math.max(s.length(), m.length())];
        // 获取next数组
        getNextVal(next, m);
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

    public  void  getNextVal(int[] nextVal, String m ){
        nextVal[0] = -1;
        int j = 0, k = -1;
        while(j < m.length() - 1){
            if(k == -1 || m.charAt(j) == m.charAt(k)){
                j++;
                k++;
                // 例如ABCDABD 如果i=5时匹配失败，那么回溯到i=1，但是i=1和i=5后面的字符是相同的，下一次匹配必定失败，通过以下操作避免这种问题
                // 如果前缀和后缀的后一个字符不同，设置当前k值为nextVal[j]
                if( m.charAt(j) != m.charAt(k)){
                    nextVal[j] = k;
                }else{
                    // 否则回溯到前缀和后缀的后一个字符不同，避免产生前缀和后缀的后一个字符相同匹配失败后再次重复匹配失败的问题
                    nextVal[j] = nextVal[k];
                }
            } else
                j = nextVal[j];
        }
        System.out.println(Arrays.toString(nextVal));
    }
}





