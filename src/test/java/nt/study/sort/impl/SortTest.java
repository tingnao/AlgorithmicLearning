package nt.study.sort.impl;


import nt.study.sort.impl.*;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {


    /**
     * 测试选择排序
     */
    @Test
    public void testSelectSort() {
        int[] ints1 = {1, 4, 7, 3, 5, 0, 0};
        // 选择排序
        long start = System.currentTimeMillis();
        new SelectSort().sort(ints1);
        System.out.println("选择排序后结果为：");
        System.out.println(Arrays.toString(ints1));
    }


    /**
     * 测试插入排序
     */
    @Test
    public void testInsertSort(){
        int[] ints2 = {1, 4, 7, 3, 5, 0, 1};
        // 插入排序
        new InsertSort().sort(ints2);
        System.out.println("插入排序后结果为：");
        System.out.println(Arrays.toString(ints2));
    }


    /**
     * 测试希尔排序
     */
    @Test
    public void testShellSort(){
        // 希尔排序
        int[] ints3 = {1, 4, 7, 3, 5, 0, 1};
        new ShellSort().sort(ints3);
        System.out.println("希尔排序后结果为：");
        System.out.println(Arrays.toString(ints3));
    }


    /**
     * 测试归并排序
     */
    @Test
    public void testMergeSort(){
        // 归并排序
        int[] ints4 = {1, 4, 7, 3, 5, 0, 1};
        new MergeSort().sort(ints4);
        System.out.println("归并排序后结果为：");
        System.out.println(Arrays.toString(ints4));
    }


    /**
     * 测试快速排序
     */
    @Test
    public void testFastSort() {
        // 快速排序
        int[] ints5 = {1, 9, 7, 3, 5, 0, 2};
        new QuickSort().sort(ints5);
        System.out.println("快速排序后结果为：");
        System.out.println(Arrays.toString(ints5));
    }

}