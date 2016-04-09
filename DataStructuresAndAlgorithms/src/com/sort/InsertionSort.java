package com.sort;

import java.util.Arrays;

/**
 * Created by prasanth on 30/3/16.
 */
public class InsertionSort {

    static void sort(Comparable[] arr){

        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j>0;j--){
                if( less( arr[j] , arr[j-1] ) ){
                    exch( arr , j ,j-1);
                }else
                    break;
            }
        }

    }



    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Integer a[]={7,10,5,3,8,4,2,3,9,6};
        sort(a);

        System.out.println(Arrays.toString(a));
    }

}
