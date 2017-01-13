import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGui3CPlus extends JPanel implements ActionListener{
	JFrame frame;

	public static void main(String[] args){
		SimpleGui3CPlus gui = new SimpleGui3CPlus();
		gui.go();
	}

	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);

		JButton button = new JButton("Change colors");
		button.addActionListener(this);

		SimpleGui3CPlus drawPanel = new SimpleGui3CPlus();

		Container pane = frame.getContentPane();
		pane.add(BorderLayout.CENTER, drawPanel);
		pane.add(BorderLayout.SOUTH, button);

	}

	public void actionPerformed(ActionEvent event){
		frame.repaint();
	}

	public void paintComponent(Graphics g){

		// g.fillRect(0, 0, this.getWidth(), this.getHeight());

		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		Color newColor = new Color(red, green, blue);

		g.setColor(newColor);
		g.fillOval(50, 30, 200, 200);
	}
}
