import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGui2B implements ActionListener{
	JButton button1;
	JButton button2;

	public static void main(String[] args){
		SimpleGui2B gui = new SimpleGui2B();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		button1 = new JButton("click me");
		button2 = new JButton("No, click ME!");

		button1.addActionListener(this);
		button2.addActionListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		frame.setSize(300, 300);
		frame.setVisible(true);

		pane.add(BorderLayout.NORTH, button1);
		pane.add(BorderLayout.SOUTH, button2);
	}

	public void actionPerformed(ActionEvent event){
		((JButton)(event.getSource())).setText("I've been clicked!");
	}
}
