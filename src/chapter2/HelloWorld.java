package chapter2;

import javax.swing.JFrame;

public class HelloWorld {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Title: Hello World");
		HelloComponent hello = new HelloComponent();
		frame.getContentPane().add(hello);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
