package nt.study.find.impl;

import nt.study.find.Find;

/**
 * 递归的二分查找
 */
public class BinaryFind implements Find {

    @Override
    public int find(int[] arr, int i) {
        int index = this.binaryFind(arr, i, 0, arr.length - 1);
        return index;
    }

    private int binaryFind(int[] arr, int i, int left, int right) {
        if(left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if(arr[mid] > i){
            return binaryFind(arr, i, left, mid - 1);
        }else if(arr[mid] < i){
            return binaryFind(arr, i, mid + 1, right);
        }else{
            return mid;
        }
    }
}
