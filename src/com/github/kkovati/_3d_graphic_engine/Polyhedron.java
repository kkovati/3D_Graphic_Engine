package com.github.kkovati._3d_graphic_engine;

import java.awt.Graphics;

/**
 * 3 dimensional object
 */
public interface Polyhedron {

    void update(Camera cam, double deltaTime);

    void display(Graphics g);

}
