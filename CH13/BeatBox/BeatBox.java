import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class BeatBox{
	JFrame frame;
	// JPanel westPanel;		// panel for labels
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
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		// getScreenSizes returns real screen size including taskbar/panel
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(this.frame.getGraphicsConfiguration());
		// This works only if taskbar/panel is located at the top.
		// To support both top and bottom, get the coordinate of the top and bottom of frame,
		// get the distance of frame and screen edge and substract the sum from the screen height.
		this.frame.setSize(screenSize.width, screenSize.height - insets.top);
		this.frame.setVisible(true);

		Container pane = this.frame.getContentPane();

		// // West: all the label of instruments
		// // JPanel westPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));		// does not work
		// westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		// // westPanel.setBackground(Color.blue);
		// pane.add(BorderLayout.WEST, westPanel);

		// TODO widen so that all label can fit in
		// Center: labels for instruments and checkboxes representing beats
		// this.centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));		// does not work
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(new GridLayout(16, 17));
		// westPanel.setBackground(Color.blue);
		pane.add(BorderLayout.CENTER, this.centerPanel);
		try{
			Files.lines(Paths.get("/home/mojito/coding/java/HeadFirstJava/CH13/BeatBox/Instruments.conf"))
				// .forEachOrdered(s -> this.initLabelAndCheckbox(this.centerPanel, westPanel, s));
				// .forEachOrdered(s -> this.initLabelAndCheckbox(this.centerPanel, s));
				.forEachOrdered(s -> this.initLabelAndCheckbox(s));
		}
		catch(IOException ex){
			System.out.println("err: \"" + ex.getMessage() + "\" was not found.");
		}

		// FIXME looks ugly
		// East: buttons
		this.eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		pane.add(BorderLayout.EAST, this.eastPanel);
		this.eastPanel.add(new JButton("Start"));
		this.eastPanel.add(new JButton("Stop"));
		this.eastPanel.add(new JButton("Tempo Up"));
		this.eastPanel.add(new JButton("Tempo Down"));


		this.frame.validate();		// without this, components will not be displayed properly
	}

	// this method has to receive center and west panel or it throws NullPointerException...
	// private void initLabelAndCheckbox(JPanel centerPanel, JPanel westPanel, String instName){
	// private void initLabelAndCheckbox(JPanel centerPanel, String instName){
	private void initLabelAndCheckbox(String instName){
		// JPanel westPanelForEachInst = new JPanel();
		// westPanelForEachInst.add(new JLabel(instName));
		// JPanel centerPanelForEachInst = new JPanel();
		this.centerPanel.add(new JLabel(instName));
		for(int i = 0; i < 16; i++){
			this.centerPanel.add(new JCheckBox());
		}
		// westPanel.add(westPanelForEachInst);
		// this.centerPanel.add(centerPanelForEachInst);
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



