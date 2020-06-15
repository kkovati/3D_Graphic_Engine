package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 * The single component inside Frame,
 * provides Graphics object for the controller and models to
 */
public class Panel extends JPanel{

	/**
	 * Displays grid lines, mainly used for debugging
	 * Background is above grid lines, so grid lines cannot be seen
	 */
	public void display() {
		Graphics g = getGraphics();
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.RED);

		//horizontal grid lines
		g.drawLine(0, 0, Settings.diplayWidth, 0);
		g.drawLine(0, Settings.diplayHeight / 4, Settings.diplayWidth, Settings.diplayHeight / 4);
		g.drawLine(0, Settings.diplayHeight / 2, Settings.diplayWidth, Settings.diplayHeight / 2);
		g.drawLine(0, Settings.diplayHeight * 3 / 4, Settings.diplayWidth, Settings.diplayHeight * 3 / 4);
		g.drawLine(0, Settings.diplayHeight, Settings.diplayWidth, Settings.diplayHeight);
		
		//vertical grid lines
		g.drawLine(0, 0, 0, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth / 4, 0, Settings.diplayWidth / 4, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth / 2, 0, Settings.diplayWidth / 2, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth * 3 / 4, 0, Settings.diplayWidth * 3 / 4, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth, 0, Settings.diplayWidth, Settings.diplayHeight);

		//diagonal grid lines
		g.drawLine(0, 0, Settings.diplayWidth, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth, 0, 0, Settings.diplayHeight);
		
		g.setColor(Color.BLACK);

	}
	
}
