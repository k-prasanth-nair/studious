package com.dp.absfactory;

/**
 * Created by prasanth on 12/3/16.
 */
public abstract class Memory {

    @Override
    public String toString() {
        return String.format("%s %d",getClass(), hashCode());
    }
}

