package chapter2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HelloComponent3 extends JComponent implements MouseMotionListener,
		ActionListener {
	String theMessage;
	int messageX = 125, messageY = 95; //  メッセージの座標
	
	JButton theButton;
	
	int colorIndex;	// someColorsの現在の指標
	
	static Color[] someColors = {
		Color.black, Color.red, Color.green, Color.blue, Color.magenta};
	
	public HelloComponent3(String message){
		theMessage = message;
		theButton = new JButton("Change Color");
		setLayout(new FlowLayout());
		add(theButton);
		theButton.addActionListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		g.drawString(theMessage, messageX, messageX);
	}

	public void mouseDragged(MouseEvent e) {
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}
	
	public void mouseMoved(MouseEvent e) {}
	
	public void actionPerformed(ActionEvent e){
		// 誰かがボタンを押した？
		if(e.getSource() == theButton){
			changeColor();
		}
	}
	
	synchronized private void changeColor(){
		//　厄介な法オフで指標を次のカラーに変更する
		if(++colorIndex == someColors.length){
			colorIndex = 0;
		}
		setForeground(currentColor());
		repaint();
	}
	synchronized private Color currentColor(){
		return someColors[colorIndex];
	}
}
