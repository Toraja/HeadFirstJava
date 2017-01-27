import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TryGridLayout{
	JPanel panel;

	public static void main(String[] args){
		TryGridLayout gui = new TryGridLayout();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 600);
		frame.setVisible(true);

		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setLayout(new GridLayout(4, 4));
		frame.getContentPane().add(BorderLayout.CENTER, panel);

		String label = "";
		for(int i = 0; i < 16; i++){
			panel.add(new JLabel(label));
			label += "label ";
		}
	}
}

