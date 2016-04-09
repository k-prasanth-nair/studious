package com.conference;

import java.util.ArrayList;

/**
 * Created by prasanth on 11/3/16.
 */
public class Track {

    private MorningSession morningSession = new  MorningSession();

    private AfterNoonSession afterNoonSession = new  AfterNoonSession();

    public boolean addToTrack(Talk t){

        if( !morningSession.isValid() ){

            if ( morningSession.addTalk(t) ){
                return true;
            }else{
                return afterNoonSession.addTalk(t);
            }

        }else{
            return afterNoonSession.addTalk(t);
        }

    }


   public boolean isTrackValid(){
       System.out.println("afterNoonSession"+afterNoonSession.isValid());
       return morningSession.isValid() && afterNoonSession.isValid();
   }

}
