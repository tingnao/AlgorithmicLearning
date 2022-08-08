package nt.study.sort.impl;

import nt.study.sort.Sort;

import java.util.Arrays;

public class InsertSort implements Sort{

    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i ; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    Sort.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 4, 7, 3, 5, 0, 0};
        new InsertSort().sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
