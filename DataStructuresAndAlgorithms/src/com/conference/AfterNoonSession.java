package com.conference;

import java.util.ArrayList;

/**
 * Created by prasanth on 11/3/16.
 */
public class AfterNoonSession {

    private ArrayList<Talk> oTalks;

    private boolean isValid ;

    private int sum;

    public AfterNoonSession(){
        oTalks = new ArrayList<Talk>();
    }


    public boolean addTalk(Talk t){

        System.out.println("Inside after noon Session"+t.getName());

        boolean isAdded = false;

        if( sum < 240 ) {

            if( t.getDuration() == 0 ){
                if( sum > 181 ){
                    oTalks.add(t);
                    isValid = true;
                    isAdded = true;
                }
                return isAdded;
            }else{

                int duration = sum + t.getDuration();

                if( duration  <= 240) {
                    isAdded = true;
                    sum = duration;
                    if(duration > 180 && duration <= 240){
                        isValid = true;
                    }
                }
            }

        }

        return isAdded;


    }

    public boolean isValid(){
        return isValid;
    }


}
