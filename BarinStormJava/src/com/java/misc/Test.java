package com.java.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by prasanth on 23/3/16.
 */
public class Test {

    public enum Operation{
        Insert,
        Delete
    }
    public static void main(String[] args) {
        List<Integer> oList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of elements in List");

        int n = in.nextInt();

        System.out.println(" Enter elements ");

        for(int i =0;i< n ; i++){
            oList.add(in.nextInt());
        }


        System.out.println("Provide number of queries");

        int q = in.nextInt();

        if(q<=0) throw new IllegalArgumentException("");

        for(int j=0;j<q;j++){

            System.out.println("Enter the operation");

            String op= in.next();

            switch(Operation.valueOf(op)){
                case Insert: System.out.println("Enter the values");
                             int pos = in.nextInt();
                             int numb = in.nextInt();
                             if( pos < 0 || pos >= n   ) throw new IllegalArgumentException("");
                             oList.add(pos,numb);
                             break;
                case Delete: System.out.println("Enter the values");
                     int index1 = in.nextInt();
                    if( index1 < 0 || index1 >= n   ) throw new IllegalArgumentException("");
                    oList.remove(index1) ;
                    break;


            }

        }


        System.out.println("Arraylist contains: " + oList.toString());





    }

    public static String[] getDetails( Scanner in ){
        String detail= in.nextLine();
        if(detail.isEmpty()) throw new IllegalArgumentException("");
        return detail.split(" ");
    }

}
