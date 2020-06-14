package com.github._3d_graphical_engine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Engine {

    Frame frame = new Frame(this);

    private ObjectManager manager = new ObjectManager();

    private Camera cam = new Camera(0,0,1,0,0);

    private Graphics graphics;

    //TODO
    MyFrameTest t = new MyFrameTest("Test");

    public Engine()
    {
        graphics = frame.getPanelGraphics();
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
        long refreshTimeUpdate = 35; //in ms
        long startTimeUpdate = System.currentTimeMillis();

        long refreshTimeDraw = 1000 / Settings.MAX_FPS;
        long startTimeDraw = System.currentTimeMillis();

        while(true) {

            if(System.currentTimeMillis() - startTimeUpdate >= refreshTimeUpdate) {
                long deltaTime = System.currentTimeMillis() - startTimeUpdate;
                startTimeUpdate = System.currentTimeMillis();
                this.update(deltaTime * Settings.TIME_SPEED / 1000); //in sec
                t.update(deltaTime);
            }

            if(System.currentTimeMillis() - startTimeDraw >= refreshTimeDraw) {
                startTimeDraw = System.currentTimeMillis();
                frame.display();
                this.display();
                t.draw();
            }
        }
    }
}
