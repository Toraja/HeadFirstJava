import javax.sound.midi.*;
import java.util.concurrent.TimeUnit;

public class MiniMusicPlayer2 implements ControllerEventListener{

	public static void main(String[] args){
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.play();
	}

	public void play(){
		final int SM_CHANNEL_PIANO = 1;
		final int SM_DEFAULT_INTENSITY = 100;
		final int SM_CONTROLLER_EVENT = 176;

		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			int[] eventIWant = {127};
			sequencer.addControllerEventListener(this, eventIWant);
			// sequencer.addControllerEventListener(event -> System.out.println("la"), eventIWant);
			int[] eventForEnd = {126};
			sequencer.addControllerEventListener(event -> sequencer.close(), eventForEnd);

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			int i = 9;		// starts from 9 as initializaion takes time
			for(; i <= 69; i+=4){
				track.add(createShortMessage(ShortMessage.CONTROL_CHANGE, SM_CHANNEL_PIANO, 127, 0, i));
				track.add(createShortMessage(ShortMessage.NOTE_ON, SM_CHANNEL_PIANO, 27 + i, SM_DEFAULT_INTENSITY, i));
				track.add(createShortMessage(ShortMessage.NOTE_OFF, SM_CHANNEL_PIANO, 27 + i, SM_DEFAULT_INTENSITY, i + 3));
			}
			// event for closing sequencer
			track.add(createShortMessage(ShortMessage.CONTROL_CHANGE, SM_CHANNEL_PIANO, 126, 0, i+8));

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(120);
			// sequencer.setLoopCount(1);
			sequencer.start();

			// TimeUnit.SECONDS.sleep(10);
			// sequencer.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void controlChange(ShortMessage event){
		System.out.println("la");
	}

	public MidiEvent createShortMessage(int type, int channel, int tone, int intensity, int Tick){
		ShortMessage sm = null;

		try{
			sm = new ShortMessage();
			sm.setMessage(type, channel, tone, intensity);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		return new MidiEvent(sm, Tick);
	}

}
