import javax.swing.*;
import java.awt.*;

public class MyDrawPanelMix extends JPanel{
	JButton button;

	public static void main(String[] args){
		JFrame frame = new JFrame();
		MyDrawPanelMix gui = new MyDrawPanelMix();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		Container pane = frame.getContentPane();
		pane.add(gui);
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(150, 60, 50, 50);
		g.fillRect(220, 80, 50, 50);
		Image image = new ImageIcon("cat.jpeg").getImage();
		g.drawImage(image, 3, 50, this);
	}
}
