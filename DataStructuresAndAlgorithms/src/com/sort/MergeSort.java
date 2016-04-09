package com.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by prasanth on 6/4/16.
 */
public class MergeSort {

    private static void merge(Comparable[] arr,Comparable aux[],int lo,int mid,int hi) {

        //assert isSorted(arr,lo,mid);

        for(int k=0;k<=hi;k++){
            aux[k] = arr[k];
        }

        int i = lo, j = mid+1;

        for(int k=lo;k<=hi;k++){
            if( i > mid) arr[k] = aux[j++];
            else if( j > hi ) arr[k] = aux[i++];
            else if( less( aux[j], aux[i] ) ) arr[k] = aux[j++];
            else arr[k] = aux[i++];

        }

    }

    private static void sort(Comparable[] a,Comparable[] aux,int lo,int hi){
        if(hi <= lo) return ;
        int mid = lo + (hi - lo) /2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    static void sort(Comparable[] a){
        Comparable[]  aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }



    static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if( less( a[i],a[i-1] ) ){
                return false;
            }
        }
        return true;
    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer a[]={7,10,5,3,8,4,2,3,9,6};
        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
