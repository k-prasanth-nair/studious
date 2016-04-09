package com.conference;

import java.util.ArrayList;

/**
 * Created by prasanth on 11/3/16.
 */
public class MorningSession {

    private ArrayList<Talk> oTalks;

    private boolean isValid ;

    private int sum;

    public MorningSession(){
        oTalks = new ArrayList<Talk>();
    }


    public boolean addTalk(Talk t){

        System.out.println("Inside Morning Session");

       boolean isAdded = false;

       if(sum < 180) {

           if( t.getDuration() == 0 ){
               if( sum > 121 ){
                   oTalks.add(t);
                   isValid = true;
                   isAdded = true;
               }
               return isAdded;
           }else{
               int duration = sum + t.getDuration();

               if( duration  <= 180) {
                   isAdded = true;
                   sum = duration;
                   if(duration > 120 && duration <= 180){
                       isValid = true;
                   }
               }
           }

       }

        System.out.println("Inside Morning Session sum"+sum);

       return isAdded;


    }

    public boolean isValid(){
        return isValid;
    }





}
