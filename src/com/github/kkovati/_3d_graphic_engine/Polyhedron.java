package com.github.kkovati.graphic_engine_3d;

import java.awt.Graphics;

/**
 * 3 dimensional object
 */
public interface Polyhedron {

    void update(Camera cam, double deltaTime);

    void display(Graphics g);

}
