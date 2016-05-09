package com.brian.view;

import com.brian.controller.GameController;
import com.brian.model.Game;
import com.brian.model.Ship;
import com.brian.utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by brian on 07/05/16.
 */
public class RaceApplet extends java.applet.Applet implements Observer {
    private BufferedImage ship = null;
    private BufferedImage bg = null;
    private GameController gc;


    private Game game;
    public void init(){
        setPreferredSize(new Dimension(600,600));
        setSize(600,600);
        try {
            ship = ImageIO.read(getClass().getResource("/com/brian/images/testship.gif")); //TODO: use getImage() and getCodebase() and make this web and stuff
            bg = ImageIO.read(getClass().getResource("/com/brian/images/bg.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        game = new Game();
        game.addObserver(this);
        gc  = new GameController(game);

        gc.addShip(400,200);
        gc.addPlayer(200,200);
        Thread gameThread = new Thread(game);
        gameThread.start();


    }

    public void paint(Graphics g){
        g.drawImage(this.bg, 0, 0,
                (int)getBounds().getWidth(), (int)getBounds().getHeight(), this);
        for (Ship s: game.getShips().values()){
            //System.out.println("Painted a ship");
            g.drawImage(ship, s.getX(), s.getY(), this);
        }
        System.out.println("Done repainting, time since last call: " + Utils.timeSinceLastCall());

    }

    @Override
    public void update(Observable o, Object arg) {
        validate();
        repaint();
        System.out.println("Told the system to repaint");
    }
}
