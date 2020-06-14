package com.github._3d_graphical_engine;

public class Engine {

    Frame frame = new Frame("Camera");

    //TODO
    MyFrameTest t = new MyFrameTest("Test");

    public Engine()
    {

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
                frame.update(deltaTime * Settings.TIME_SPEED / 1000); //in sec
                t.update(deltaTime);
            }

            if(System.currentTimeMillis() - startTimeDraw >= refreshTimeDraw) {
                startTimeDraw = System.currentTimeMillis();
                frame.display();
                t.draw();
            }
        }
    }
}
