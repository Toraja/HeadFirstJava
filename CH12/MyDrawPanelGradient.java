import javax.swing.*;
import java.awt.*;

public class MyDrawPanelGradient extends JPanel{
	JButton button;

	public static void main(String[] args){
		JFrame frame = new JFrame();
		MyDrawPanelGradient gui = new MyDrawPanelGradient();

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

		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);

		g.setPaint(gradient);
		g.fillOval(70, 70, 100, 100);
	}
}
