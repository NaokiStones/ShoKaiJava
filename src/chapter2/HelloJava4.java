package chapter2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava4 {
	public static void main(String[] args){
		JFrame frame = new JFrame("HelloJava4");
		frame.getContentPane().add(new HelloComponent4("Hello Java!"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
