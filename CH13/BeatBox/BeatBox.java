import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;

public class BeatBox{
	private static ArrayList<String> instrumentsList;
	private static final int NUM_OF_BEATS = 16;
	private JFrame frame;
	private JPanel westPanel;		// panel for labels
	private JPanel centerPanel;		// panel for checkboxes
	private JPanel eastPanel;		// panel for buttons
	private JButton startButton;
	private JButton stopButton;
	private JButton tempoUpButton;
	private JButton tempoDownButton;

	static {
		BeatBox.instrumentsList = new ArrayList<String>();
		try{
			Files.lines(Paths.get("/home/mojito/coding/java/HeadFirstJava/CH13/BeatBox/Instruments.conf"))
				.forEachOrdered(s -> BeatBox.instrumentsList.add(s));
		}
		catch(IOException ex){
			System.err.println("err: \"" + ex.getMessage() + "\" was not found.");
			throw new Error(ex);
		}
	}

	public static void main(String[] args){
		BeatBox gui = new BeatBox();
		gui.init();
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

		// West: all the label of instruments
		this.westPanel = new JPanel();
		this.westPanel.setLayout(new GridLayout(BeatBox.instrumentsList.size(), 1));
		pane.add(BorderLayout.WEST, this.westPanel);

		// Center: labels for instruments and checkboxes representing beats
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(new GridLayout(BeatBox.instrumentsList.size(), BeatBox.NUM_OF_BEATS));
		pane.add(BorderLayout.CENTER, this.centerPanel);

		for(String instrument : BeatBox.instrumentsList){
			this.westPanel.add(new JLabel(instrument));
			for(int i = 0; i < BeatBox.NUM_OF_BEATS; i++){
				this.centerPanel.add(new JCheckBox());
			}
		}

		// East: buttons
		this.eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(8, 1, 5, 20));
		pane.add(BorderLayout.EAST, this.eastPanel);
		this.startButton = new JButton("Start");
		this.stopButton = new JButton("Stop");
		this.tempoUpButton = new JButton("Tempo Up");
		this.tempoDownButton = new JButton("Tempo Down");
		this.startButton.addActionListener(new StartButtonListener());
		this.stopButton.addActionListener(new StopButtonListener());
		this.tempoUpButton.addActionListener(new TempoUpListener());
		this.tempoDownButton.addActionListener(new TempoDownListener());
		this.eastPanel.add(startButton);
		this.eastPanel.add(stopButton);
		this.eastPanel.add(tempoUpButton);
		this.eastPanel.add(tempoDownButton);


		this.frame.validate();		// without this, components will not be displayed properly
	}

	class StartButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("StartButtonListener");
		}
	}
	class StopButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("StopButtonListener");
		}
	}
	class TempoUpListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("TempoUpListener");
		}
	}
	class TempoDownListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("TempoDownListener");
		}
	}

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



