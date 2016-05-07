package com.brian.model;

import java.util.ArrayList;
import java.util.Observable;
import com.brian.utils.Utils;
/**
 * Created by brian on 06/05/16.
 */
public class Game extends Observable implements Runnable{


    private ArrayList<Ship> ships;

    private static final int TPS = 30;
    private static final int SKIP_TICKS = 1000/TPS;

    private boolean running = true;

    public Game(){
        this.ships = new ArrayList<>();
    }

    @Override
    public void run() {
        Ship test = new Ship();
        test.setX(200);
        test.setY(200);
        int nextTick = Utils.getTickCount();
        int sleepTicks = 0;
        while(running){
            update();
            nextTick += SKIP_TICKS;
            sleepTicks = nextTick - Utils.getTickCount();
            if (sleepTicks > 0) try {
                Thread.sleep(sleepTicks);
            } catch (InterruptedException e) {
                e.printStackTrace(); //cry, TODO: cry less
            }
            else {
                //cry more. TODO: don't cry
            }
        }

    }

    private void update(){
        ships.forEach(Ship::update);
        setChanged();
        notifyObservers();

    }

    private boolean addShip(Ship s){
        boolean add = ships.add(s);
        return add;
    }


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

}
