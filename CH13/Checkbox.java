import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Checkbox{
	JPanel panel;

	public static void main(String[] args){
		Checkbox gui = new Checkbox();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);

		panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.EAST, panel);

		JPanel panel4Label = new JPanel();
		panel4Label.setBackground(Color.CYAN);
		panel4Label.setLayout(new BoxLayout(panel4Label, BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.WEST, panel4Label);

		for(int i = 0; i < 10; i++){
			JPanel subPanel = new JPanel();
			int red = (int)(Math.random() * 236) + 20;
			int green = (int)(Math.random() * 236) + 20;
			int blue = (int)(Math.random() * 236) + 20;
			Color newColor = new Color(red, green, blue);
			subPanel.setBackground(newColor);

			panel4Label.add(new Label("Label " + i));

			for(int j = 0; j < 10; j++){
				subPanel.add(new JCheckBox());
			}
			panel.add(subPanel);
		}

		frame.validate();
	}
}

