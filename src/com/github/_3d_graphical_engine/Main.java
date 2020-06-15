package com.github._3d_graphical_engine;

public class Main {

    public static void main(String[] args) {

        testingStuff();

        Engine engine = new Engine();

        engine.add(new Point(2,2,1));

        engine.add(new Cube(2,0,1,1));
        engine.add(new Cube(4,3,3,1));

        engine.add(new Octahedron(5, 5, 0, 1));

        engine.run();
    }



    public static void testingStuff() {


    }


}
