package com.ds.strings;

import java.util.Scanner;

/**
 * Created by prasanth on 26/3/16.
 */
public class LeftTriangle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter n ");
        int n =  in.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("#");
            }
            System.out.println("");
        }
    }
}
