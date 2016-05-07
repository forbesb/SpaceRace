package com.brian.model;

import java.util.HashMap;
import java.util.Observable;
import java.util.UUID;

import com.brian.utils.Utils;
/**
 * Created by brian on 06/05/16.
 */
public class Game extends Observable implements Runnable{


    private HashMap<UUID, Ship> ships;

    private static final int TPS = 30;
    private static final int SKIP_TICKS = 1000/TPS;

    private boolean running = true;

    public Game(){
        this.ships = new HashMap<>();
    }

    @Override
    public void run() {
        int nextTick = Utils.getTickCount();
        int sleepTicks;
        while(running){
            update();
            nextTick += SKIP_TICKS;
            sleepTicks = nextTick - Utils.getTickCount();
            if (sleepTicks > 0) try {
                Thread.sleep(sleepTicks);
                //System.out.println("Slept for: " + sleepTicks);
            } catch (InterruptedException e) {
                e.printStackTrace(); //cry, TODO: cry less
            }
            else {
                //cry more. TODO: don't cry
            }
        }

    }

    private void update(){
        ships.values().forEach(Ship::update);
        setChanged();
        notifyObservers();
    }

    public void addShip(Ship s){
        ships.put(s.getID(), s);
    }


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public HashMap<UUID, Ship> getShips() {
        return ships;
    }

    public void setShips(HashMap<UUID, Ship> ships) {
        this.ships = ships;
    }

}
