package nt.study.sort.impl;

import nt.study.sort.Sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int []arr, int left, int right){
        if(left >= right){
            return;
        }
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition);
        quickSort(arr, partition + 1, right);
    }
    public int partition(int []arr, int left, int right){
        // 定义基准值
        int pivot = left;
        int index = pivot + 1;
        for(int i = index; i <= right; i++){
            if(arr[i] < arr[pivot]){
                Sort.swap(arr, i, index);
                index ++;
            }
        }
        Sort.swap(arr, pivot, -- index);
        return index;
    };

}
