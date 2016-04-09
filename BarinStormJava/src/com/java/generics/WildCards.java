package com.java.generics;

/**
 * Created by prasanth on 19/3/16.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Sometimes we would like lists to behave more like arrays, in that we want to accept
   not only a list with elements of a given type, but also a list with elements of any subtype
   of a given type. For this purpose, we use wildcards.

 */
public class WildCards {

    public static void main(String[] args) {


        /**
         *          interface Collection<E> {
         ...
                        public boolean addAll(Collection<? extends E> c);
         ...
                    }
         *
         */


        List<Number> nums = new ArrayList<Number>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(dbls);
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");


        /*

        The first call is permitted because nums has type List<Number> , which is a subtype of
        Collection<Number> , and ints has type List<Integer> , which is a subtype of Collec
        tion<? extends Number> . The second call is similarly permitted. In both calls, E is taken
        to be Number . If the method signature for addAll had been written without the wildcard,
        then the calls to add lists of integers and doubles to a list of numbers would not have
        been permitted; you would only have been able to add a list that was explicitly declared
        to be a list of numbers.
        */


        List<Integer> ints1 = new ArrayList<Integer>();
        ints1.add(1);
        ints1.add(2);
        List<? extends Number> nums1 = ints1;
        // nums1.add(3.14); // compile-time error
        assert ints1.toString().equals("[1, 2, 3.14]");

        /**
         *
         *       ? extends E , we can
                 get elements out of the structure, but we cannot put elements into the structure. To
                 put elements into the structure we need another kind of wildcard, as explained in the
                 next section.
         */



        //Wild Card with Super

        /**
         *      public static <T> void copy(List<? super T> dst, List<? extends T> src) {
                    for (int i = 0; i < src.size(); i++) {
                         dst.set(i, src.get(i));
                    }
                }
         *
         */

        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints2 = Arrays.asList(5, 6);
        Collections.copy(objs, ints2);
        assert objs.toString().equals("[5, 6, four]");

    }


}
