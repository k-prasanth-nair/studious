package com.java.generics;

import java.util.Arrays;

/**
 * Created by prasanth on 19/3/16.
 */
public class ArraysG {


    /**
     *
     *  When an array is
        allocated (as on the first line), it is tagged with its reified type (a run-time representation
        of its component type, in this case, Integer ), and every time an array is assigned into
        (as on the third line), an array store exception is raised if the reified type is not com-
        patible with the assigned value (in this case, a double cannot be stored into an array of
         Integer ).
        In contrast, the subtyping relation for generics is invariant, meaning that type List<S

     * @param args
     */
    public static void main(String[] args) {

        Integer[] ints = new Integer[] {1,2,3};
        Number[] nums = ints;
        nums[2] = 3.14; // array store exception
        assert Arrays.toString(ints).equals("[1, 2, 3.14]"); // uh oh!
    }

}
