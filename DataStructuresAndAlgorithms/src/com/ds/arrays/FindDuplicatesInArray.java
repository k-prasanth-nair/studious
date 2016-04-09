package com.ds.arrays;

/**
 * Created by prasanth on 26/3/16.
 */
public class FindDuplicatesInArray {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        findDuplicates(arr);

    }

    static void findDuplicates(int[] arr){

        for(int i=0;i<arr.length;i++){

            System.out.println( "Math.abs(arr[i]) "+Math.abs(arr[i]) );
            System.out.println( "arr[Math.abs(arr[i])] "+arr[Math.abs(arr[i])] );
            if(arr[Math.abs(arr[i])]>=0){
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }else{
                System.out.println(Math.abs(arr[i]));
            }
        }
    }

}
