package chapter2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava3 {
	public static void main(String[] args){
		JFrame frame = new JFrame("Hello Java3");
		frame.getContentPane().add(new HelloComponent3("Hello Java!"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		//
	}
}
