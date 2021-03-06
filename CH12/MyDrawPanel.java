import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel{
	JButton button;

	public static void main(String[] args){
		JFrame frame = new JFrame();
		MyDrawPanel gui = new MyDrawPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		Container pane = frame.getContentPane();
		pane.add(gui);
	}

	// This is always called by system
	// The argument is the canvas provided to you by system
	// to draw whatever you want
	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(20, 50, 50, 100);
	}
}
