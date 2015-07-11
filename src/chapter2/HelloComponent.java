package chapter2;

import java.awt.*;

import javax.swing.JComponent;


public class HelloComponent extends JComponent {
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.drawString("Hello, Java", 125, 95);
	}
}
