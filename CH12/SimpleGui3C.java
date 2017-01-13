import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGui3C implements ActionListener{
	JFrame frame;

	public static void main(String[] args){
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}

	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);

		JButton button = new JButton("Change colors");
		button.addActionListener(this);

		MyDrawPanel3C drawPanel = new MyDrawPanel3C();

		Container pane = frame.getContentPane();
		pane.add(BorderLayout.CENTER, drawPanel);
		pane.add(BorderLayout.SOUTH, button);

	}

	public void actionPerformed(ActionEvent event){
		frame.repaint();
	}
}

class MyDrawPanel3C extends JPanel{
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

