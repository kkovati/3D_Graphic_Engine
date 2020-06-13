package com.github._3d_graphical_engine;

import java.awt.Graphics;

public class Point {
	
	private double x0,y0,z0;
	private double xRel,yRel,zRel;
	private boolean visible; // 
	
	private double xDisp, yDisp;
	
	private double size = 10;
	
	public Point(double x0, double y0, double z0) {
		this.x0 = x0;
		this.y0 = y0;
		this.z0 = z0;
	}
	
	public void update(Camera cam) {
		
		//movement of camera
		xRel = x0 - cam.x();
		yRel = y0 - cam.y();
		zRel = z0 - cam.z();
		
		//these calculations can be easier, deg->rad has to be deleted
		//alphas can be dismissed
		
		//rolling around Z axis
		double r = Math.sqrt(xRel*xRel + yRel*yRel);
		double alpha0 = Math.signum(yRel) * Math.toDegrees(Math.acos(xRel/r));
		double alpha1 = alpha0 - cam.viewDirHor();
		xRel = r * Math.cos(Math.toRadians(alpha1));
		yRel = r * Math.sin(Math.toRadians(alpha1));
		
		//rolling around Y axis
		r = Math.sqrt(xRel*xRel + zRel*zRel);
		alpha0 = Math.signum(zRel) * Math.toDegrees(Math.acos(xRel/r));
		if(alpha0 > 90)
			alpha0 -= 180;
		else if(alpha0 < -90)
			alpha0 += 180; 
		alpha1 = alpha0 - cam.viewDirVer();
		zRel = r * Math.sin(Math.toRadians(alpha1));
		xRel = (xRel < 0 ? -1 : 1) * r * Math.cos(Math.toRadians(alpha1));
	}
	
	public void draw(Graphics g) {
		
		//these have to move to update()
		//d0 can be moved to constants
		
		//virtual distance of monitor from camera (in pixels)
		double d0 = Constants.diplayWidth/(2*Math.tan(Math.toRadians(Constants.viewAngleHor/2)));
		
		//coordinate on monitor (origo in middle)
		double x = d0*yRel/xRel;
		
		//coordinate on monitor (origo in middle)		
		double y = d0*zRel/xRel;
		
		//coordinate on monitor (origo at top left)
		xDisp = -x + Constants.diplayWidth/2;
		yDisp = -y + Constants.diplayHeight/2;
		
		if(x < Constants.diplayWidth/2 && x > -Constants.diplayWidth/2 && y < Constants.diplayHeight/2 && y > -Constants.diplayHeight/2 && xRel > 0) {
			g.fillOval((int)(xDisp - (size/2)),(int)(yDisp - (int)(size/2)), (int)size, (int)size );
			visible = true;
		} else {
			visible = false;
		}
		
		//test:
		Test.xRel = xRel;
		Test.yRel = yRel;
		Test.zRel = zRel;
		
	}
	
	public double xDisp() {
		return xDisp;
	}
	
	public double yDisp() {
		return yDisp;
	}
	
	public boolean IsVisible() {
		return visible;
	}
	
	public double getX() {
		return x0;
	}
	
	public double getY() {
		return y0;
	}
	
	public double getZ() {
		return z0;
	}

}
