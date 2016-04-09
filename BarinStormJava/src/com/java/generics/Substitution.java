package com.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prasanth on 19/3/16.
 */
public class Substitution {
    public static void main(String[] args) {


        //Integer is a subtype of Number

        //Float is a subtype of Number

        //List<E> is a subtype op Collection<E


        List<Number> nums = new ArrayList<Number>();
        nums.add(2);
        nums.add(3.14);
        assert nums.toString().equals("[2, 3.14]");

        // The above is perfectly fine

        //But

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);

        // List<Number> nums1 = ints; Compile time Error



        ///List<Integer> is not a subtype of List<Number> , nor is List<Number> a subtype of
        //List<Integer> ; all we have is the trivial case, where List<Integer> is a subtype of itself,

        //and we also have that List<Integer> is a subtype of Collection<Integer>

    }
}
