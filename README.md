# 3D Graphic Engine

[![Demo](https://github.com/kkovati/3D_Graphic_Engine/blob/master/docs/3D_Graphic_Engine_sample_13_sec.gif)](https://youtu.be/o-YfCyEvu08)

## 🚀 Overview
A lightweight 3D graphic engine written in Java, built from scratch without any external 3D libraries.<br>
The project implements:
- 3D transformations (translations, rotations, scaling), 
- perspective projection (converting 3D space to 2D screen coordinates),
- real-time perspective adjustments (move and rotate the viewpoint dynamically) and
- rendering pipeline (with basic 3D shape support).

GUI and rendering is done using Java Swing's graphical drawing tools.

## 📽️ Demo
Check out the engine in action! Watch the [demo video on YouTube](https://youtu.be/o-YfCyEvu08).

This video shows how the engine renders some cubes and octahedrons 
while the viewpoint (camera) changes directions and moves around. (Poor upload resolution.)

## 💻 Getting Started
Create and run the 3D scene above with [this sample code](https://github.com/kkovati/3D_Graphic_Engine/blob/master/src/main/java/com/github/kkovati/graphic_engine_3d/Main.java):

```java
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
```
