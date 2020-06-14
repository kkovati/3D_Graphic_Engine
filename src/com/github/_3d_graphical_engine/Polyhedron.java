package com.github._3d_graphical_engine;

import java.awt.Graphics;

/**
 * 3 dimensional object
 */
public interface Polyhedron {

    void update(Camera cam, double deltaTime);

    void display(Graphics g);

}
