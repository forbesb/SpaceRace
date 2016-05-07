package com.brian.utils;

/**
 * Created by brian on 06/05/16.
 */
public class Utils {
    private static long initialTime = 0;
    private static long lastcall = 0;

    public static int getTickCount(){
        long ctime = System.currentTimeMillis(); //get current time
        if (initialTime == 0){
            initialTime = ctime; //this does weird things on the first call but is fine after, TODO: Reconsider?
        }
        long elapsedtime = ctime-initialTime; //get time between current time and last call
        //System.out.println("Current Time "+ ctime + ", Initial Time: "+ initialTime + ", Elapsed Time: "+elapsedtime);

        return (int) elapsedtime; //return difference
    }

    public static int timeSinceLastCall(){
        long ctime = System.currentTimeMillis(); //get current time
        if (lastcall == 0){
            lastcall = ctime; //this does weird things on the first call but is fine after, TODO: Reconsider?
        }
        long elapsedtime = ctime-lastcall; //get time between current time and last call
        lastcall = ctime;
        return (int) elapsedtime; //return difference
    }
}
