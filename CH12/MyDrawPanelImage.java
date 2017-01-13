import javax.swing.*;
import java.awt.*;

public class MyDrawPanelImage extends JPanel{
	JButton button;

	public static void main(String[] args){
		JFrame frame = new JFrame();
		MyDrawPanelImage gui = new MyDrawPanelImage();

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
		Image image = new ImageIcon("cat.jpeg").getImage();
		g.drawImage(image, 3, 4, this);
	}
}
