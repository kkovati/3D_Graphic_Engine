package com.github._3d_graphical_engine;

import javax.swing.JFrame;

public class MyFrameTest extends JFrame{
	
	private MyPanelTest p = new MyPanelTest();
	
	public MyFrameTest(String title) {
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Test.Disp+10, Test.Disp+32);
		setLocationRelativeTo(null); //set frame in middle of monitor
		setVisible(true);
		setResizable(false);
		setLocation(0, 0);
		
		add(p);				
	}
	
	public void update(double deltaTime) {
		p.update(deltaTime);
	}
	
	public void draw() {
		p.draw();
	}	
	

}
