package chapter2;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HelloComponent2 extends JComponent implements MouseMotionListener{
	String theMessage;
	int messageX = 125, messageY = 95;
	
	public HelloComponent2(String message){
		theMessage = message;
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		g.drawString(theMessage, messageX, messageY);
	}
	
	public void mouseDragged(MouseEvent e){
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		messageX = 2 *e.getX();
		messageY = 3 *e.getY();
		repaint();
	}
}
