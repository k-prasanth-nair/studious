package com.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prasanth on 19/3/16.
 */
public class WildCardCapture {

    public static <T> void reverse(List<T> list){

        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size()-i-1));
        }
    }

    public static void reverse1(List<?> list) {
        List<Object> tmp = new ArrayList<Object>(list);
        for (int i = 0; i < list.size(); i++) {
           //  list.set(i, tmp.get(list.size()-i-1)); // compile-time error

            //, because we are trying  to write from a list of objects into a list of unknown type
        }
    }


    // Capturing the WIld Card

    public static void reverse2(List<?> list) { rev(list); }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size()-i-1));
        }
    }


    public static void main(String[] args) {


        /**
         *  p   ublic static void reverse(List<?> list);
                public static void <T> reverse(List<T> list);
         */



    }


}
