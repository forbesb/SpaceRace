package com.brian.utils;

/**
 * Created by brian on 06/05/16.
 */
public class Utils {
    private static long initialTime = 0;

    public static int getTickCount(){
        long ctime = System.currentTimeMillis(); //get current time
        if (initialTime == 0){
            initialTime = ctime; //this does weird things on the first call but is fine after, TODO: Reconsider?
        }
        long elapsedtime = ctime-initialTime; //get time between current time and last call
        initialTime = ctime; //update last call to this call
        return (int) elapsedtime; //return difference
    }
}
