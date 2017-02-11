import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonWithLambda{
	JButton button;

	public static void main(String[] args){
		ButtonWithLambda gui = new ButtonWithLambda();
		// gui.goEast();
		gui.goNorth();
	}

	public void goEast(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("click me");
		button.addActionListener(event -> {
			if(button.getText() == "click me"){
				button.setText("Did you really click me?");
			}
			else{
				button.setText("click me");
			}
		});
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.setSize(170, 170);
		frame.setVisible(true);
	}

	public void goNorth(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("There is no spoon...");
		button.addActionListener(event -> {
			if(button.getFont().getSize() == 28){
				Font smallfont = new Font("Dialog", Font.BOLD, 12);
				button.setFont(smallfont);
			}
			else{
				Font smallfont = new Font("serif", Font.BOLD, 28);
				button.setFont(smallfont);
			}
		});
		frame.getContentPane().add(BorderLayout.NORTH, button);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}
