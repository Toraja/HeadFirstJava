import javax.sound.midi.*;
import java.util.concurrent.TimeUnit;

public class MiniMiniMusicApp{

	static final int MSG_TYPE_NOTE_ON = 144;
	static final int MSG_TYPE_NOTE_OFF = 128;

	// static final int SM_CHANNEL_PIANO = 1;

	public static void main(String[] args){
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}

	public void play(){
		try{
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();
			ShortMessage sm1 = new ShortMessage();
			sm1.setMessage(MSG_TYPE_NOTE_ON, 1, 44, 100);
			MidiEvent noteOn = new MidiEvent(sm1, 1);
			track.add(noteOn);

			ShortMessage sm2 = new ShortMessage();
			sm2.setMessage(MSG_TYPE_NOTE_OFF, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(sm2, 16);
			track.add(noteOff);

			player.setSequence(seq);

			player.start();

			TimeUnit.SECONDS.sleep(3);
			player.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
