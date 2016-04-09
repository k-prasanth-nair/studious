package com.ds.strings;

/**
 * Created by prasanth on 26/3/16.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        removeDuplicates("Heellowoorldd");

    }

    static void removeDuplicates(String s){
        boolean[] visited = new boolean[256];
        StringBuilder oSB = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(!visited[s.charAt(i)]){
                visited[s.charAt(i)] = true;
                oSB.append(s.charAt(i));
            }
        }

        System.out.println(oSB.toString());
    }
}
