import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleAnimation{
	JFrame frame;
	JLabel label;

	int xcoord = 15;
	int ycoord = 15;

	public static void main(String[] args){
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}

	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);

		MyDrawPanelAnimation drawPanel = new MyDrawPanelAnimation();

		Container pane = frame.getContentPane();
		pane.add(BorderLayout.CENTER, drawPanel);

		for(int i = 0; i < 130; i++){
			frame.repaint();
			try{
				Thread.sleep(50);
			}
			catch(InterruptedException e){
				System.out.println("Hey, don't disturb my sleep dream, would you?");
			}
		}
	}

	// it gets rough as it proceeds
	class MyDrawPanelAnimation extends JPanel{
		public void paintComponent(Graphics g){

			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			// int red = (int)(Math.random() * 256);
			// int green = (int)(Math.random() * 256);
			// int blue = (int)(Math.random() * 256);
			// Color newColor = new Color(red, green, blue);

			// g.setColor(newColor);
			g.setColor(Color.green);
			g.fillOval(xcoord+=1, ycoord+=1, 80, 80);
		}
	}
}


