import javax.swing.*;
import java.awt.*;

public class MyDrawPanelGradientRandom extends JPanel{
	JButton button;

	public static void main(String[] args){
		JFrame frame = new JFrame();
		MyDrawPanelGradientRandom gui = new MyDrawPanelGradientRandom();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		Container pane = frame.getContentPane();
		pane.add(gui);
	}

	// This is always called by system
	// The argument is the canvas provided to you by system
	// to draw whatever you want
	public void paintComponent(Graphics gr){
		Graphics2D g = (Graphics2D) gr;
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		Color startColor = new Color(red, green, blue);

		red = (int)(Math.random() * 256);
		green = (int)(Math.random() * 256);
		blue = (int)(Math.random() * 256);
		Color endColor = new Color(red, green, blue);

		GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);

		g.setPaint(gradient);
		g.fillOval(70, 70, 100, 100);
	}
}
