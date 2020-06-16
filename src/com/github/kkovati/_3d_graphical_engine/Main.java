package com.github.kkovati._3d_graphical_engine;

public class Main {

    public static void main(String[] args) {

        Engine engine = new Engine();

        //tower
        engine.add(new Cube(2,0,1,1));
        engine.add(new Cube(2,0,2,1));
        engine.add(new Cube(2,0,3,1));
        engine.add(new Cube(2,0,4,1));

        //cube inside cube
        engine.add(new Cube(-2,-2,1,1));
        engine.add(new Cube(-2,-2,1,0.5));

        //two octahedron top of each other
        engine.add(new Octahedron(5, 5, 1.2, 1));
        engine.add(new Octahedron(5, 5, 2.3, 0.5));

        //single octahedron
        engine.add(new Octahedron(5, -5, 2, 1));

        engine.run();
        
    }

}
