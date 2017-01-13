import javax.swing.*;
import java.awt.*;

public class MyDrawPanelRandomBg extends JPanel{
	JButton button;

	public static void main(String[] args){
		JFrame frame = new JFrame();
		MyDrawPanelRandomBg gui = new MyDrawPanelRandomBg();

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
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);

		Color randomColor = new Color(red, green, blue);
		g.setColor(randomColor);
		g.fillOval(70, 70, 100, 100);
	}
}
