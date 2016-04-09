package com.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by prasanth on 19/3/16.
 */
public class GetAndPutPrinciple {


    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) s += num.doubleValue();
        return s;
    }


    public static void main(String[] args) {

        /**
         *  The Get and Put Principle: use an extends wildcard when you only get values out of a
            structure, use a super wildcard when you only put values into a structure, and don’t use
            a wildcard when you both get and put
         */

        List<Integer> ints = Arrays.asList(1,2,3);
        assert sum(ints) == 6.0;

        List<Double> doubles = Arrays.asList(2.78,3.14);
        assert sum(doubles) == 5.92;

        List<Number> nums = Arrays.<Number>asList(1, 2, 2.78, 3.14);
        assert sum(nums) == 8.92;


        List<Integer> ints1 = new ArrayList<Integer>();
        ints1.add(1);
        ints1.add(2);
        List<? extends Number> nums1 = ints1;
        double dbl = sum(nums1); // ok
       //  nums1.add(3.14); // compile-time error



    }



}
