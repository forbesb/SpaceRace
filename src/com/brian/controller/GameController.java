package com.brian.controller;

import com.brian.model.Game;
import com.brian.model.Ship;

import java.util.UUID;

/**
 * Created by brian on 07/05/16.
 */
public class GameController {
    private Game game;
    public GameController(Game g){
        this.game = g;
    }

    public UUID addShip(int x, int y){
        Ship s = new Ship();
        s.setX(x);
        s.setY(y);
        UUID id = UUID.randomUUID();
        s.setID(id);
        this.game.addShip(s);
        return id;
    }


}
