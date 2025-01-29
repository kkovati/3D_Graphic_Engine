package com.github.kkovati.graphic_engine_3d.objects;

import java.awt.Graphics;

import com.github.kkovati.graphic_engine_3d.engine.Camera;

/**
 * 3 dimensional object
 */
public interface Polyhedron {

    void update(Camera cam, double deltaTime);

    void display(Graphics g);

}
