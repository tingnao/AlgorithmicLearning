package nt.study.sort.impl;

import nt.study.sort.Sort;

public class SelectSort implements Sort {

    public  void sort(int[] arr){
        // 1. 找到无序区最小的数 将其与无序区的第一个数进行交换
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            Sort.swap(arr, index, i);
        }
    }



}
