import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGui4D{
	JFrame frame;
	JLabel label;

	public static void main(String[] args){
		SimpleGui4D gui = new SimpleGui4D();
		gui.go();
	}

	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);

		JButton buttonChangeColor = new JButton("Change colors");
		JButton buttonChangeText = new JButton("Change text");
		buttonChangeColor.addActionListener(new MyListener4DColor());
		buttonChangeText.addActionListener(new MyListener4DText());

		MyDrawPanel4D drawPanel = new MyDrawPanel4D();

		label = new JLabel("sup?");

		Container pane = frame.getContentPane();
		pane.add(BorderLayout.CENTER, drawPanel);
		pane.add(BorderLayout.SOUTH, buttonChangeColor);
		pane.add(BorderLayout.EAST, buttonChangeText);
		pane.add(BorderLayout.WEST, label);
	}

	class MyListener4DColor implements ActionListener {

		public void actionPerformed(ActionEvent event){
			frame.repaint();
		}
	}

	class MyListener4DText implements ActionListener {

		public void actionPerformed(ActionEvent event){
			label.setText("You've clicked my bro.");
		}
	}

	class MyDrawPanel4D extends JPanel{
		public void paintComponent(Graphics g){

			// g.fillRect(0, 0, this.getWidth(), this.getHeight());

			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			Color newColor = new Color(red, green, blue);

			g.setColor(newColor);
			g.fillOval(100, 80, 100, 100);
		}
	}
}


