package chapter2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HelloComponent4 extends JComponent implements MouseMotionListener,
		ActionListener, Runnable {

	String theMessage;
	int messageX = 125, messageY = 95;
	
	JButton theButton;
	
	int colorIndex;	// 現在のsomeColorsへの指標
	static Color[] someColors = {
		Color.black, Color.red, Color.green, Color.blue, Color.magenta
	};
	
	boolean blinkState;
	
	public HelloComponent4(String message){
		theMessage = message;
		theButton = new JButton("Change Color");
		setLayout(new FlowLayout());
		add(theButton);
		theButton.addActionListener(this);
		addMouseMotionListener(this);
		Thread t = new Thread(this);
		t.start();
	}
	
	public void paintComponent(Graphics g){
		g.setColor(blinkState ? getBackground(): currentColor());
		g.drawString(theMessage, messageX, messageY);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == theButton)
			changeColor();
	}
	
	synchronized private void changeColor(){
		if(++colorIndex == someColors.length)
			colorIndex = 0;
		setForeground(currentColor());
		repaint();
	}
	
	synchronized private Color currentColor(){
		return someColors[colorIndex];
	}

	public void mouseDragged(MouseEvent e) {
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}

	public void mouseMoved(MouseEvent e) {}

	public void run() {
		try {
			while(true){
				blinkState = !blinkState;
				repaint();
				Thread.sleep(300);
			}
		} catch (InterruptedException e) {
		}
	}
}
