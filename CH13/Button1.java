import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button1{
	JButton button;

	public static void main(String[] args){
		Button1 gui = new Button1();
		// gui.goEast();
		gui.goNorth();
	}

	public void goEast(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("click me");
		button.addActionListener(new EastListener());
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.setSize(170, 170);
		frame.setVisible(true);
	}

	class EastListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(button.getText() == "click me"){
				button.setText("Did you really click me?");
			}
			else{
				button.setText("click me");
			}
		}
	}

	public void goNorth(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("There is no spoon...");
		button.addActionListener(new NorthListener());
		frame.getContentPane().add(BorderLayout.NORTH, button);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	class NorthListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(button.getFont().getSize() == 28){
				Font smallfont = new Font("Dialog", Font.BOLD, 12);
				button.setFont(smallfont);
			}
			else{
				Font smallfont = new Font("serif", Font.BOLD, 28);
				button.setFont(smallfont);
			}
		}
	}
}
