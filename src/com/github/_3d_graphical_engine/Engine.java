package com.github._3d_graphical_engine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * The main controller class
 * Handles and connects the models and views
 */
public class Engine {

    //Application window
    Frame frame = new Frame(this);

    //Handles the model of the objects
    private ObjectManager manager = new ObjectManager();

    //Camera models the point of view
    private Camera cam = new Camera(0,0,1,0,0);

    //Graphics from Panel
    private Graphics graphics = frame.getPanelGraphics();

    public boolean running;

    public Engine() {
        running = false;
        //left empty on purpose
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

        //flag overwritten in exit() method
        running = true;

        while(running) {

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

    public void exit(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            running = false;
        }
    }
}
