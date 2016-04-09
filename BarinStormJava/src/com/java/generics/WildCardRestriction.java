package com.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prasanth on 19/3/16.
 */
public class WildCardRestriction {

    public static void main(String[] args) {

        // List<?> list = new ArrayList<?>(); /Compile time error

        List<?> list = new ArrayList<Object>(); // OK


        List<Number> nums = new ArrayList<Number>();
        List<? super Number> sink = nums;
        List<? extends Number> source = nums;
        for (int i=0; i<10; i++) sink.add(i);
        double sum=0; for (Number num : source) sum+=num.doubleValue();


        List<Object> list1 = new ArrayList<Object>(); // OK
        list1.add("abc");
        list1.add(123);

    }

    static void test(List<Object> list1){
        list1.add("abc");
        list1.add(123);
    }

}
