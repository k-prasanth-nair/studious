package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prasanth on 19/3/16.
 */
public class Inroduction {


    //A Generic methoid
    public static <T> List<T> toList(T[] arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }

    //Varagrs
    public static <T> List<T> toList1(T... arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }

    public static void main(String[] args) {

        List<Integer> oList = Arrays.asList(1,2,3);
        int s= 0;
        for(int n:oList){
            s+=n;
        }
        assert(s == 6) ;

        toList(new Integer[] { 1, 2, 3 });

        toList1(1,2,3,4);

        //Before generics in Java 1.4

        /**
         *   List ints = Arrays.asList( new Integer[] {
             new Integer(1), new Integer(2), new Integer(3)
             } );
             int s = 0;
             for (Iterator it = ints.iterator(); it.hasNext(); ) {
             int n = ((Integer)it.next()).intValue();
             3s += n;
             }
             assert s == 6;
         *
         */
    }
}
