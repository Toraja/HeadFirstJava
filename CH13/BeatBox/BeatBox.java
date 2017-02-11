import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.sound.midi.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;

// TODO fix button width
// TODO make label look better
public class BeatBox{
	private static ArrayList<String> instrumentsList;
	private static ArrayList<Integer> channelList;
	private static final int NUM_OF_BEATS = 16;

	private BeatBox beatBox;
	private JFrame frame;
	private JPanel westPanel;		// panel for labels
	private JPanel centerPanel;		// panel for checkboxes
	private JPanel eastPanel;		// panel for buttons
	private ArrayList<MyCheckBox> checkboxList;
	private JButton startButton;
	private JButton stopButton;
	private JButton clearButton;
	private JButton tempoUpButton;
	private JButton tempoDownButton;
	private JLabel tempoLabel;
	private Sequencer sequencer;
	private Sequence sequence;
	private Track track;

	private float tempoMargin = 0.03f;

	static {
		BeatBox.instrumentsList = new ArrayList<String>();
		// BeatBox.channelList = new ArrayList<Integer>();
		try{
			Files.lines(Paths.get("/home/mojito/coding/java/HeadFirstJava/CH13/BeatBox/Instruments.conf"))
				.forEachOrdered(s -> BeatBox.instrumentsList.add(s));
				// .forEachOrdered(s -> {
					// BeatBox.instrumentsList.add(s.split(":")[0]);
					// BeatBox.channelList.add(Integer.parseInt(s.split(":")[1]));
				// });
		}
		catch(IOException ex){
			System.err.println("err: \"" + ex.getMessage() + "\" was not found.");
			throw new Error(ex);
		}
	}

	public BeatBox(){
		this.beatBox = this;
		this.buildGui();
		this.setupMidi();
	}

	public static void main(String[] args){
		BeatBox bb = new BeatBox();
	}

	/**
	 * initialise components
	 */
	// TODO adjust button size to the width of east panel
	private void buildGui(){
		// frame
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
/* this part is to set window to maximus size. currently the window size is set to just enough to show all components
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		// getScreenSizes returns real screen size including taskbar/panel
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(this.frame.getGraphicsConfiguration());
		// This works only if taskbar/panel is located at the top.
		// To support both top and bottom, get the coordinate of the top and bottom of frame,
		// get the distance of frame and screen edge and substract the sum from the screen height.
		this.frame.setSize(screenSize.width, screenSize.height - insets.top);
 */
		JPanel background = new JPanel(new BorderLayout());
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.frame.getContentPane().add(background);

		// West: all the label of instruments
		this.westPanel = new JPanel();
		this.westPanel.setLayout(new GridLayout(BeatBox.instrumentsList.size(), 1));
		background.add(BorderLayout.WEST, this.westPanel);

		// Center: labels for instruments and checkboxes representing beats
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(new GridLayout(BeatBox.instrumentsList.size(), BeatBox.NUM_OF_BEATS, 2, 1));
		background.add(BorderLayout.CENTER, this.centerPanel);

		this.checkboxList = new ArrayList<MyCheckBox>();
		BeatBox.instrumentsList.stream().forEachOrdered(instrument -> {
			this.westPanel.add(new JLabel(instrument.split(":")[0]));
			for(int i = 0; i < BeatBox.NUM_OF_BEATS; i++){
				MyCheckBox checkbox = new MyCheckBox(Integer.parseInt(instrument.split(":")[1]), i + 1);
				this.checkboxList.add(checkbox);
				this.centerPanel.add(checkbox);
			}
		});

		// East: buttons
		this.eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		background.add(BorderLayout.EAST, this.eastPanel);
		this.startButton = new JButton("Start");
		this.stopButton = new JButton("Stop");
		this.clearButton = new JButton("Clear");
		this.tempoUpButton = new JButton("Tempo Up");
		this.tempoDownButton = new JButton("Tempo Down");
		this.tempoLabel = new JLabel();
		this.startButton.addActionListener(event -> beatBox.buildTrackAndPlay());
		this.stopButton.addActionListener(event -> sequencer.stop());
		this.clearButton.addActionListener(
				event -> this.checkboxList.stream()
				.forEachOrdered(checkbox -> checkbox.setSelected(false))
				);
		this.tempoUpButton.addActionListener(event -> {
			this.sequencer.setTempoFactor(this.sequencer.getTempoFactor() + this.tempoMargin);
			this.updateTempoLabel();
		});
		this.tempoDownButton.addActionListener(event -> {
			this.sequencer.setTempoFactor(this.sequencer.getTempoFactor() - this.tempoMargin);
			this.updateTempoLabel();
		});
		this.eastPanel.add(this.startButton);
		this.eastPanel.add(this.stopButton);
		this.eastPanel.add(this.clearButton);
		this.eastPanel.add(this.tempoUpButton);
		this.eastPanel.add(this.tempoDownButton);
		this.eastPanel.add(this.tempoLabel);


		// this.frame.validate();		// without this, components will not be displayed properly
		this.frame.setBounds(50,50,300,300);
		this.frame.pack();				// resize the window so that all components fit into i
		this.frame.setVisible(true);	// by invoking setVisible() at the end, you don't have to show ugly uncompleted gui
	}

	private void setupMidi(){
		try{
			this.sequencer = MidiSystem.getSequencer();
			this.sequencer.open();
			this.sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			this.sequencer.setTempoInBPM(120);
			this.sequence = new Sequence(Sequence.PPQ, 4);
			this.updateTempoLabel();
			this.track = this.sequence.createTrack();		// just for the sake of avoiding error when deleting track for the first time
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new Error(ex);
		}
	}

	private void buildTrackAndPlay(){
		this.sequence.deleteTrack(track);
		this.track = this.sequence.createTrack();

		this.checkboxList.stream()
			.filter(checkbox -> checkbox.isSelected())
			.forEachOrdered(checkbox -> {
				this.makeTrack(checkbox.getInstCode(), checkbox.getBeat());
		});

		// TODO what is this for?
		this.track.add(this.makeMidiEvent(ShortMessage.PROGRAM_CHANGE, 9, 1, 0, BeatBox.NUM_OF_BEATS));

		try{
			this.sequencer.setSequence(this.sequence);
			this.updateTempoLabel();
			this.sequencer.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new Error(ex);
		}
	}

	private void makeTrack(int instCode, int tick){
		final int SM_DEFAULT_INTENSITY = 100;
		ShortMessage smOn = null;
		ShortMessage smOff = null;
		ShortMessage smConChange = null;

			// TODO what is channel 9?
			this.track.add(this.makeMidiEvent(ShortMessage.NOTE_ON, 9, instCode, SM_DEFAULT_INTENSITY, tick));
			this.track.add(this.makeMidiEvent(ShortMessage.NOTE_OFF, 9, instCode, SM_DEFAULT_INTENSITY, tick));
			if(tick == BeatBox.NUM_OF_BEATS){
				// TODO what is this CONTROL_CHANGE for?
				this.track.add(this.makeMidiEvent(ShortMessage.CONTROL_CHANGE, 1, 127, 0, tick));
			}
	}

	private MidiEvent makeMidiEvent(int type, int channel, int dataOne, int dataTwo, int tick){
		try{
			return new MidiEvent(new ShortMessage(type, channel, dataOne, dataTwo), tick);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new Error(ex);
		}
	}

	private void updateTempoLabel(){
		this.tempoLabel.setText(String.valueOf((int)(this.sequencer.getTempoFactor() * 100)));
	}
}

class MyCheckBox extends JCheckBox{
	private int instCode;
	private int beat;

	MyCheckBox(int instCode, int beat){
		this.instCode = instCode;
		this.beat = beat;
	}

	public int  getInstCode(){
		return this.instCode;
	}

	public int  getBeat(){
		return this.beat;
	}
}

