package com.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by prasanth on 6/4/16.
 */
public class SelectionSort {


    public static void sort(Comparable[] a){
        int n = a.length;

        for(int i=0;i<n;i++){
            int min = i;

            for(int j=i+1;j<n;j++){
                if( less( a[j] , a[min] ) ){
                    min = j;
                }
            }
            exch(a,i,min);
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
