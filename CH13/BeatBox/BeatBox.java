import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class BeatBox{
	JFrame frame;
	JPanel westPanel;		// panel for labels
	JPanel centerPanel;		// panel for checkboxes
	JPanel eastPanel;		// panel for buttons
	// JLabel label;
	// JCheckBox check;

	public static void main(String[] args){
		BeatBox gui = new BeatBox();
		gui.init();
		// gui.start();
	}

	// initialise components
	public void init(){
		// frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		// getScreenSizes returns real screen size including taskbar/panel
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
		// you have to know where the taskbar/panel is located...
		// or get the coordinate of the top and bottom of frame,
		// get the distance of frame and screen edge and
		// substract the sum from the screen height.
		frame.setSize(screenSize.width, screenSize.height - insets.top);
		frame.setVisible(true);

		Container pane = frame.getContentPane();

		// west: all the label of instruments
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		pane.add(BorderLayout.WEST, westPanel);
		try{
			// FIXME this is working but not displayed properly. any way to refresh swing window?
			Files.lines(Paths.get("/home/mojito/coding/java/HeadFirstJava/CH13/BeatBox/Instruments.conf"))
				.forEachOrdered(s -> westPanel.add(new JLabel(s)));
		}
		catch(IOException ex){
			// ex.printStackTrace();
			System.out.println("err: \"" + ex.getMessage() + "\" was not found.");
		}

		// center:

		// buttonChangeColor.addActionListener(new MyListener4DColor());
		// buttonChangeText.addActionListener(new MyListener4DText());

		// MyDrawPanel4D drawPanel = new MyDrawPanel4D();

		// label = new JLabel("sup?");

		// Container pane = frame.getContentPane();
		// pane.add(BorderLayout.CENTER, drawPanel);
		// pane.add(BorderLayout.WEST, label);

		frame.validate();		// without this, components will not be displayed properly
	}

	// class MyListener4DColor implements ActionListener {

		// public void actionPerformed(ActionEvent event){
			// frame.repaint();
		// }
	// }

	// class MyListener4DText implements ActionListener {

		// public void actionPerformed(ActionEvent event){
			// label.setText("You've clicked my bro.");
		// }
	// }

	// class MyDrawPanel4D extends JPanel{
		// public void paintComponent(Graphics g){

			// // g.fillRect(0, 0, this.getWidth(), this.getHeight());

			// int red = (int)(Math.random() * 256);
			// int green = (int)(Math.random() * 256);
			// int blue = (int)(Math.random() * 256);
			// Color newColor = new Color(red, green, blue);

			// g.setColor(newColor);
			// g.fillOval(100, 80, 100, 100);
		// }
	// }
}



