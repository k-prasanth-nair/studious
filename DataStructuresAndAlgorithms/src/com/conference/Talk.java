package com.conference;

/**
 * Created by prasanth on 11/3/16.
 */
public class Talk {

    private String name;

    private int duration ;

    public Talk(String name, int duration){
        this.name=name;
        this.duration = duration;
    }


    public int getDuration(){
        return duration;
    }

    public String getName(){
        return name;
    }



    @Override
    public boolean equals(Object o) {

        if(this == o) return true;

        if (!(o instanceof Talk)) {
            return false;
        }

        Talk that = (Talk)o;

        return this.name.equals(that.name) && (this.duration == that.duration);
    }



}
