package com.github._3d_graphical_engine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Set;

/**
 * The main controller class
 * Handles and connects the models and views
 */
public class Engine {

    Frame frame = new Frame(this);


    private ObjectManager manager = new ObjectManager();

    //Camera models the point of view
    private Camera cam = new Camera(0,0,1,0,0);

    //Graphics form Panel
    private Graphics graphics;

    public Engine()
    {
        graphics = frame.getPanelGraphics();
    }

    public void add(Point p) {
        manager.add(p);
    }

    public void add(Polyhedron p) {
        manager.add(p);
    }

    public void update(double deltaTime) {
        manager.update(cam, deltaTime);
    }

    public void display() {
        manager.display(graphics);

        //for testing reasons only
        cam.display(graphics);
    }

    public void camMove(KeyEvent e) {
        cam.move(e);
    }

    public void camRotate(MouseEvent e) {
        cam.rotate(e);
    }

    public void run() {
        long refreshTimeUpdate = Settings.UPDATE_TIME;
        long startTimeUpdate = System.currentTimeMillis();

        long refreshTimeDisplay = 1000 / Settings.MAX_FPS;
        long startTimeDisplay = System.currentTimeMillis();

        while(true) {

            if(System.currentTimeMillis() - startTimeUpdate >= refreshTimeUpdate) {
                long deltaTime = System.currentTimeMillis() - startTimeUpdate;
                startTimeUpdate = System.currentTimeMillis();
                this.update(deltaTime * Settings.TIME_SPEED / 1000); //in sec
            }

            if(System.currentTimeMillis() - startTimeDisplay >= refreshTimeDisplay) {
                startTimeDisplay = System.currentTimeMillis();
                frame.display();
                this.display();
            }
        }
    }
}
