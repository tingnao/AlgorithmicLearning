package nt.study.sort;

public interface Sort {
    void sort(int[] arr);


     static void swap(int []arr, int i, int j){
//        if(arr[i] == arr[j]){
//            return ;
//        }
         if(i == j){
             return;
         }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
