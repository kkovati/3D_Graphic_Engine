# 3D Graphical Engine
A simple 3 dimensional graphical engine written in Java.  
All the 3D display calculations implemented in the project,
without any external 3D library.  
The GUI made with Java Swing, visualized with its graphical drawing tools.

Runtime: Java 11  
IDE: IntelliJ IDEA 2020.1

### Example video
The following sample code 

```java
Engine engine = new Engine();

engine.add(new Cube(2,0,1,1));
engine.add(new Cube(4,3,3,1));
    
engine.add(new Octahedron(5, 5, 0, 1));
engine.add(new Octahedron(5, -5, 2, 1));

engine.run();
```