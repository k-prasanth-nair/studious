package com.conference;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by prasanth on 11/3/16.
 */
public class Conference {



    private ArrayList<Track> oTracks = new ArrayList<Track>();


    public void scheduleTrack(ArrayList<Talk> oList){
        scheduleTrack(oList,new Track());
    }


    public ArrayList<Track> getTracks(){
        return oTracks;
    }


    private void scheduleTrack(ArrayList<Talk> oList,Track t){

        if(oList.isEmpty()) return;

        for(Iterator<Talk> iterator = oList.iterator();iterator.hasNext();){

            Talk talk = iterator.next();

            if( t.addToTrack(talk) ){

                if( t.isTrackValid() ){
                    oTracks.add(t);
                    scheduleTrack(oList,new Track());
                }
                iterator.remove();
            }
            scheduleTrack(oList,t);
        }
    }



    public static void main(String s[]){

        ArrayList<Talk> oList = new  ArrayList<Talk>();

        oList.add(new Talk("Writing Fast Tests Against Enterprise Rails",60));
        oList.add(new Talk("Overdoing it in Python ",45));
        oList.add(new Talk("Lua for the Masses",30));
        oList.add(new Talk("Ruby Errors from Mismatched Gem Versions",45));
        oList.add(new Talk("Common Ruby Errors",60));
        oList.add(new Talk("Communicating Over Distance",60));
        oList.add(new Talk("Accounting-Driven Development",45));
        oList.add(new Talk("Woah",30));
        oList.add(new Talk("Sit Down and Write",30));
        oList.add(new Talk("Pair Programming vs Noise",45));
        oList.add(new Talk("Rails Magic",60));
        oList.add(new Talk("Ruby on Rails: Why We Should Move On",60));
        oList.add(new Talk("Clojure Ate Scala",45));
        oList.add(new Talk("Programming in the Boondocks of Seattle",30));
        oList.add(new Talk("Ruby vs. Clojure for Back-End Development",30));
        oList.add(new Talk("Ruby on Rails Legacy App Maintenance",60));
        oList.add(new Talk("A World Without HackerNews",30));
        oList.add(new Talk("User Interface CSS in Rails App",30));

        Conference oCon = new Conference();

        oCon.scheduleTrack(oList);


        System.out.println( oCon.getTracks().size() );


    }


}
