import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlowLayout{
	JPanel panel;
	JButton button;
	JButton button2;
	JButton button3;

	public static void main(String[] args){
		FlowLayout gui = new FlowLayout();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		// frame.setSize(400, 400);
		frame.setVisible(true);

		panel = new JPanel();
		panel.setBackground(Color.darkGray);
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.EAST, panel);

		button = new JButton("long long long long long long long long long long long text");
		button2 = new JButton("long long long long long long long long long long text");
		button3 = new JButton("long long long long long long long long long long long long long text");
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
	}
}

