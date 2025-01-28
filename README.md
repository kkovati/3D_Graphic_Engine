# 3D Graphic Engine

[![Demo](https://github.com/kkovati/3D_Graphic_Engine/blob/master/docs/3D_Graphic_Engine_sample_13_sec.gif)](https://youtu.be/o-YfCyEvu08)

A simple 3 dimensional graphic engine written in Java.  
All the 3D display calculations implemented in the project,
without any external 3D library.  
The GUI made with Java Swing, visualized with its graphical drawing tools.

Runtime: Java 11  

### Example video
The following video shows a sample how the engine displays some cubes and 
octahedrons while the point of view is changing directions 
and moving around. (Poor upload resolution)

https://youtu.be/o-YfCyEvu08

The example code for this:

```java
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
```


