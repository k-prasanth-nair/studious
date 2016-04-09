package com.java.generics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by prasanth on 19/3/16.
 */
public class WildCardVersusType {

    /**
     *
     *   interface Collection<E> {
     ...
            public boolean contains(Object o);
            public boolean containsAll(Collection<?> c);
     ...
        }
     *
     *
     */

    public static void main(String[] args) {

        Object obj = "one";
        List<Object> objs = Arrays.<Object>asList("one", 2, 3.14, 4);
        List<Integer> ints = Arrays.asList(2, 4);

        assert objs.contains(obj);
        assert objs.containsAll(ints);
        assert !ints.contains(obj);
        assert !ints.containsAll(objs);



    }






}
