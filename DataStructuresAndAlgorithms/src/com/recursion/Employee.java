package com.recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by prasanth on 30/3/16.
 */
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private String city;

    public Employee(int id,String name,String city){

        this.id = id;
        this.name = name;
        this.city = city;

    }

    public int compareTo(Employee that){
        if( this == that) return 0;

       int i = this.city.compareTo(that.city);

        if(i==0){
            return this.name.compareTo(that.name);
        }
        return i;

    }


    public  String toString(){

        return "id "+id;
    }


    public static void main(String[] args) {

        ArrayList<Employee> oEmp = new ArrayList<Employee>();

        oEmp.add(new Employee(1,"A","Cochin"));
        oEmp.add(new Employee(2,"B","Delhi"));
        oEmp.add(new Employee(3,"C","Cochin"));

        Collections.sort(oEmp);

        System.out.println( oEmp );
    }

}
