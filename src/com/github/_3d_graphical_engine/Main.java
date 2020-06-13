package com.github._3d_graphical_engine;

public class Main {

    public static void main(String[] args) {

        testingStuff();

        MyFrame f = new MyFrame("Camera");
        MyFrameTest t = new MyFrameTest("Test");

        long refreshTimeUpdate = 35; //in ms
        long startTimeUpdate = System.currentTimeMillis();

        long refreshTimeDraw = 1000 / Constants.MAX_FPS;
        long startTimeDraw = System.currentTimeMillis();

        while(true) {

            if(System.currentTimeMillis() - startTimeUpdate >= refreshTimeUpdate) {
                long deltaTime = System.currentTimeMillis() - startTimeUpdate;
                startTimeUpdate = System.currentTimeMillis();
                f.update(deltaTime * Constants.TIME_SPEED / 1000); //in sec
                t.update(deltaTime);
            }

            if(System.currentTimeMillis() - startTimeDraw >= refreshTimeDraw) {
                startTimeDraw = System.currentTimeMillis();
                f.draw();
                t.draw();
            }
        }
    }

    public static void testingStuff() {
        //System.out.println(Math.signum(0.00000));

    }
}
