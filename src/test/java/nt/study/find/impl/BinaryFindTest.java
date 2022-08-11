package nt.study.find.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryFindTest {

    /**
     * 测试二分查找
     */
    @Test
    public void testBinaryFind(){
        int[] arr = {1, 3, 4, 5, 7, 9, 10};
        int i = new BinaryFind().find(arr, 4);
        System.out.println(i);
    }

    @Test
    public void testBinaryFindIterate(){
        int[] arr = {1, 3, 4, 5, 7, 9, 10};
        int i = new BinaryFindIterate().find(arr, 10);
        System.out.println(i);
    }

}