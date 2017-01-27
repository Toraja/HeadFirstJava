import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel1{
	JPanel panel;
	JButton button;
	JButton button2;
	JButton button3;

	JPanel panel2;
	JButton button4;

	public static void main(String[] args){
		Panel1 gui = new Panel1();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(200, 200);
		frame.setSize(400, 400);
		frame.setVisible(true);

		panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.EAST, panel);

		panel2 = new JPanel();
		panel2.setBackground(Color.blue);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.WEST, panel2);

		button = new JButton("click me");
		button2 = new JButton("Don't click me");
		button3 = new JButton(":-)");
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		button.addActionListener(new BListener());
		button2.addActionListener(new BListener2());

		button4 = new JButton(":-p :-o :-l :-D :-$ :^) :-9 :-*");
		button4.setFont(new Font("Dialog", Font.BOLD, 20));
		panel2.add(button4);
	}

	class BListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(button.getText() == "click me"){
				button.setText("Did you really click me?");
				Font smallfont = new Font("serif", Font.BOLD, 28);
				button.setFont(smallfont);
			}
			else{
				button.setText("click me");
				Font smallfont = new Font("Dialog", Font.BOLD, 12);
				button.setFont(smallfont);
			}
		}
	}

	class BListener2 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			button.setText("Oh my...");
			button3.setText(":-(");
			// this is ignored
			// button3.setSize(30, 30);
			try{
				Thread.sleep(500);
			}
			catch(Exception ex){
			}
			panel.remove(button2);
		}
	}
}
