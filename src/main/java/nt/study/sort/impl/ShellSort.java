package nt.study.sort.impl;

import nt.study.sort.Sort;

public class ShellSort implements Sort {
    @Override
    public void sort(int[] arr) {
        // 定义不同的步长
        int length = arr.length;
        while((length >>= 1) > 0){
            shellSort(arr, length);
        }
    }
    public void shellSort(int[] arr, int step){
        // 对步长的每一列进行插入排序
        for(int i = 0; i < step; i++){
            // 插入排序
            for(int j = i + step; j < arr.length; j += step){
                int k = j;
                int temp = arr[k];
                while(k > i && compare(temp, arr[ k - step]) < 0){
                    arr[k] = arr[k-step];
                    k -= step;
                }
                arr[k] = temp;
            }
        }
    }

    public int compare(int i , int j){
        if( i > j){
            return 1;
        }else if (i == j){
            return 0;
        }else{
            return -1;
        }
    }


}
