package com.brian.model;

import java.util.UUID;

/**
 * Created by brian on 06/05/16.
 */
public class Ship {
    private static final int MAXSPEED = 2;
    private double xspeed, yspeed;
    private int score;
    private int x;
    private int y;

    private UUID ID;

    public Ship(){
        this.xspeed = 0;
        this.yspeed = 0;
        this.score = 0;
        this.x = 0;
        this.y = 0;
    }


    public void accelerate(double n){
        this.speed = ((this.speed + n) > MAXSPEED) ? MAXSPEED : (this.speed + n);
    }



    public void update() {

        x += xmov;
        y += ymov;

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

}
