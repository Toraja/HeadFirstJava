import javax.swing.*;
import java.awt.Container;

public class SimpleGui1{
	public static void main(String[] args){

		JFrame frame = new JFrame();
		JButton button = new JButton("click me");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container pane = frame.getContentPane();
		pane.add(button);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
