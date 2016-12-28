import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;

public class ExtendedButton implements ActionListener{
	MyButton button;

	public static void main(String[] args){
		ExtendedButton gui = new ExtendedButton();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		button = new MyButton("click me");

		button.addActionListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.add(button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
		button.setText("I've been clicked!");
	}
}

class MyButton extends JButton{
	public MyButton(String s){
		super(s);
	}
}
