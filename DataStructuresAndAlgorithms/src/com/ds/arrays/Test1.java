package com.ds.arrays;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by prasanth on 26/3/16.
 */
public class Test1 {

    public static void main(String s[]){

        Pattern r  = Pattern.compile("^[4]+[0]*$");
        Matcher m  = r.matcher("44000");

        System.out.println(m.find());

        String n = ""+44000;
        System.out.println( n.substring(n.indexOf("0")) );


    }



    public static void test() throws Exception{

        throw new Exception("hi");
    }

    static class Inner
    {
        private class Private{
            private String powerof2(int num)
            {
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }


}
