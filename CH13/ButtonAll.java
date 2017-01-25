import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonAll{
	JButton east;
	JButton west;
	JButton north;
	JButton south;
	JButton center;

	public static void main(String[] args){
		ButtonAll gui = new ButtonAll();
		gui.goAll();
	}

	public void goAll(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		east = new JButton("East");
		west = new JButton("West");
		north = new JButton("North");
		south = new JButton("South");
		center = new JButton("Center");

		frame.getContentPane().add(BorderLayout.EAST, east);
		frame.getContentPane().add(BorderLayout.WEST, west);
		frame.getContentPane().add(BorderLayout.NORTH, north);
		frame.getContentPane().add(BorderLayout.SOUTH, south);
		frame.getContentPane().add(BorderLayout.CENTER, center);

		// button.addActionListener(new EastListener());
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	// class EastListener implements ActionListener{
		// public void actionPerformed(ActionEvent event){
			// if(button.getText() == "click me"){
				// button.setText("Did you really click me?");
			// }
			// else{
				// button.setText("click me");
			// }
		// }
	// }

	// public void goNorth(){
		// JFrame frame = new JFrame();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// button = new JButton("There is no spoon...");
		// button.addActionListener(new NorthListener());
		// frame.getContentPane().add(BorderLayout.NORTH, button);
		// frame.setSize(200, 200);
		// frame.setVisible(true);
	// }

	// class NorthListener implements ActionListener{
		// public void actionPerformed(ActionEvent event){
			// if(button.getFont().getSize() == 28){
				// Font smallfont = new Font("Dialog", Font.BOLD, 12);
				// button.setFont(smallfont);
			// }
			// else{
				// Font smallfont = new Font("serif", Font.BOLD, 28);
				// button.setFont(smallfont);
			// }
		// }
	// }
}
