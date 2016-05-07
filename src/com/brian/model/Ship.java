package com.brian.model;

/**
 * Created by brian on 06/05/16.
 */
public class Ship {
    private static final int MAXSPEED = 30;
    private double speed;
    private double direction;
    private int score;
    private int x;
    private int y;

    public Ship(){
        this.speed = 0;
        this.direction = 0;
        this.score = 0;
        this.x = 0;
        this.y = 0;
    }


    public void accelerate(double n){
        this.speed = ((this.speed + n) > MAXSPEED) ? MAXSPEED : (this.speed + n);
    }

    public void turn(double rads){
        this.direction += rads;
        while (this.direction > (2 * Math.PI)){
            this.direction -= 2 * Math.PI;
        }
    }

    public void update() {
        xmov = speed * Math.cos(this.direction);
        ymov = speed * Math.sin(this.direction);
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

}
