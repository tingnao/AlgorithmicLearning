package nt.study.str;

import org.junit.Test;

import static org.junit.Assert.*;

public class KMP算法Test {

    @Test
    public void testKmp(){
        String str1 = "aaabaaaab";
        String str2 = "aaaab";
        int kmp = new KMP算法().kmp(str1, str2);
        System.out.println(kmp);
    }

}