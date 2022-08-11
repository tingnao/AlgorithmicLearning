package nt.study.find.impl;

import nt.study.find.Find;

/**
 * 迭代二分查找
 */
public class BinaryFindIterate implements Find {


    @Override
    public int find(int[] arr, int i) {
        return this.binaryFindIterate(arr, i, 0, arr.length - 1);
    }

    private int binaryFindIterate(int[] arr, int i, int left, int right) {
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > i){
                right = mid - 1;
            }else if (arr[mid] < i){
                left = mid + 1;
            }else return mid;
        }
        return -1;
    }
}
