package com.github.kkovati.graphic_engine_3d;

import com.github.kkovati.graphic_engine_3d.engine.Engine;
import com.github.kkovati.graphic_engine_3d.objects.Cube;
import com.github.kkovati.graphic_engine_3d.objects.Octahedron;

public class Main {

    public static void main(String[] args) {

        Engine engine = new Engine();

        // Tower
        engine.add(new Cube(2, 0, 1, 1));
        engine.add(new Cube(2, 0, 2, 1));
        engine.add(new Cube(2, 0, 3, 1));
        engine.add(new Cube(2, 0, 4, 1));

        // Cube inside cube
        engine.add(new Cube(-2, -2, 1, 1));
        engine.add(new Cube(-2, -2, 1, 0.5));

        // Two octahedron top of each other
        engine.add(new Octahedron(5, 5, 1.2, 1));
        engine.add(new Octahedron(5, 5, 2.3, 0.5));

        // Single octahedron
        engine.add(new Octahedron(5, -5, 2, 1));

        engine.run();

    }

}
