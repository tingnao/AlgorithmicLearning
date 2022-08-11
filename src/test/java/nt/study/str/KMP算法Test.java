package nt.study.str;

import nt.study.sort.impl.InsertSort;
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

    @Test
    public void testKMPOptimization(){
        String str1 = "aaabaaaab";
        String str2 = "aaaab";
        int kmp = new 优化后的KMP算法().KMP(str1, str2);
        System.out.println(kmp);
    }

}