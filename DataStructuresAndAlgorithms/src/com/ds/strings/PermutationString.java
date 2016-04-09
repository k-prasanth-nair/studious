package com.ds.strings;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by prasanth on 17/3/16.
 */
public class PermutationString {


    public static ArrayList<String> permute(String s){
        ArrayList<String> fullSolution = new ArrayList<String>();
        if( s.length() == 1 ) {
            fullSolution.add(s);
        }
        else
        {
            for(int i=0;i<s.length();i++){
                ArrayList<String> res = new ArrayList<String>();
                String str = String.valueOf(s.charAt(i));
                res = permute( s.substring(0,i)+s.substring(i+1));
                for(int j=0;j< res.size();j++) {
                    res.set(j,str+res.get(j));
                }
                fullSolution.addAll(res);
            }

        }
        return fullSolution;
    }

    public static void  main(String s[]){

        ArrayList<String> oPermuations =  permute("ab");

        for(String option : oPermuations){
            System.out.println(option);
        }
    }

}
