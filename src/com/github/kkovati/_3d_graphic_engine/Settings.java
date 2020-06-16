package com.github.kkovati._3d_graphic_engine;

public class Settings {

	/*Time settings*/

	//time period of objects' coordinate calculations in ms
	public static final int UPDATE_TIME = 35;

	//maximum frame per second refresh rate
	public static final int MAX_FPS = 25;
	//constant time factor for kinematics
	public static final double TIME_SPEED = 0.7;

	/*Display settings and calculations*/

	//display screen size in pixels (must be same)
	public static final int diplayWidth = 1000;
	public static final int diplayHeight = 1000;
	
	//angle of view in degrees (same for both vertically and horizontally)
	public static final int viewAngleHor = 60;
	
	//a single step distance of camera while moving in space
	public static final double stepSize = 0.5;

	//virtual distance of screen from camera's position (in pixels)
	public static final double screenDist = Settings.diplayWidth / (2 * Math.tan(Math.toRadians(Settings.viewAngleHor / 2)));

}
