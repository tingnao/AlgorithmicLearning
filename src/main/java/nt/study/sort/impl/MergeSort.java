package nt.study.sort.impl;

import nt.study.sort.Sort;

public class MergeSort implements Sort {

    private int[] aux;
    @Override
    public void sort(int[] arr) {
        aux = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int left,  int right){
        if(right <= left){
            return;
        }
        int mid = left + (right - left) / 2;
        this.mergeSort(arr, left, mid);
        this.mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right){
        for(int i = left; i <= right; i++){
            aux[i] = arr[i];
        }
        int l = left;
        int r = mid + 1;
        for(int i = left; i <= right; i++){
            if(l > mid){
                arr[i] = aux[r++];
            }else if(r > right){
                arr[i] = aux[l++];
            } else if(aux[l] > aux[r]) {
                 arr[i] = aux[r++];
            }else{
                arr[i] = aux[l++];
            }
        }
    }
}
