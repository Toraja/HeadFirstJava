import java.util.Arrays;
import javax.sound.midi.*;
// import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MiniMusicPlayer3{
	JFrame frame;

	public static void main(String[] args){
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.play();
	}

	public void play(){
		// set up drawing part
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(30, 30, 500, 500);
		frame.setVisible(true);

		MyDrawPanel drawPanel = new MyDrawPanel();

		Container pane = frame.getContentPane();
		pane.add(BorderLayout.CENTER, drawPanel);

		// set up music part
		final int SM_CHANNEL_PIANO = 1;
		final int SM_DEFAULT_INTENSITY = 100;
		final int SM_CONTROLLER_EVENT = 176;

		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			int[] eventIWant = {127};
			sequencer.addControllerEventListener(drawPanel, eventIWant);

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			for(int i = 1; i < 61; i+=4){
				int tone = (int)(Math.random() * 60) + 35;
				track.add(createShortMessage(ShortMessage.CONTROL_CHANGE, SM_CHANNEL_PIANO, 127, 0, i));
				track.add(createShortMessage(ShortMessage.NOTE_ON, SM_CHANNEL_PIANO, tone, SM_DEFAULT_INTENSITY, i));
				track.add(createShortMessage(ShortMessage.NOTE_OFF, SM_CHANNEL_PIANO, tone, SM_DEFAULT_INTENSITY, i + 3));
			}

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(120);
			sequencer.start();

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public MidiEvent createShortMessage(int type, int channel, int tone, int intensity, int tick){
		ShortMessage sm = null;

		try{
			sm = new ShortMessage(type, channel, tone, intensity);
			// sm.setMessage(type, channel, tone, intensity);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		return new MidiEvent(sm, tick);
	}

	class MyDrawPanel extends JPanel implements ControllerEventListener{

		boolean noteOnMsg = false;

		public void controlChange(ShortMessage event){
			noteOnMsg = true;
			repaint();
		}

		public void paintComponent(Graphics g){
			if(noteOnMsg){
				int red = (int)(Math.random() * 236) + 20;
				int green = (int)(Math.random() * 236) + 20;
				int blue = (int)(Math.random() * 236) + 20;
				Color newColor = new Color(red, green, blue);

				g.setColor(newColor);
				g.fillOval((int)(Math.random() * 420), (int)(Math.random() * 420), (int)(Math.random() * 60) + 20, (int)(Math.random() * 60) + 20);

				noteOnMsg = false;
			}
		}

	}
}
