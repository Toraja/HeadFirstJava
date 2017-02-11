import javax.sound.midi.*;
import java.util.concurrent.TimeUnit;

public class VariousMiddleC{

	static final int SM_NOTE_ON = 144;
	static final int SM_NOTE_OFF = 128;

	static final int SM_CHANNEL_PIANO = 1;

	public static void main(String[] args){
		VariousMiddleC cccc = new VariousMiddleC();
		cccc.play();
	}

	public void play(){
		try{
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			ShortMessage sm1on = new ShortMessage();
			sm1on.setMessage(SM_NOTE_ON, SM_CHANNEL_PIANO, 36, 100);
			MidiEvent note1on = new MidiEvent(sm1on, 1);
			track.add(note1on);

			ShortMessage sm1off = new ShortMessage();
			sm1off.setMessage(SM_NOTE_OFF, SM_CHANNEL_PIANO, 36, 100);
			MidiEvent note1off = new MidiEvent(sm1off, 4);
			track.add(note1off);

			ShortMessage sm2on = new ShortMessage();
			sm2on.setMessage(SM_NOTE_ON, SM_CHANNEL_PIANO, 44, 100);
			MidiEvent note2on = new MidiEvent(sm2on, 5);
			track.add(note2on);

			ShortMessage sm2off = new ShortMessage();
			sm2off.setMessage(SM_NOTE_OFF, SM_CHANNEL_PIANO, 44, 100);
			MidiEvent note2off = new MidiEvent(sm2off, 8);
			track.add(note2off);

			ShortMessage sm3on = new ShortMessage();
			sm3on.setMessage(SM_NOTE_ON, SM_CHANNEL_PIANO, 52, 100);
			MidiEvent note3on = new MidiEvent(sm3on, 9);
			track.add(note3on);

			ShortMessage sm3off = new ShortMessage();
			sm3off.setMessage(SM_NOTE_OFF, SM_CHANNEL_PIANO, 52, 100);
			MidiEvent note3off = new MidiEvent(sm3off, 12);
			track.add(note3off);

			ShortMessage sm4on = new ShortMessage();
			sm4on.setMessage(SM_NOTE_ON, SM_CHANNEL_PIANO, 60, 100);
			MidiEvent note4on = new MidiEvent(sm4on, 13);
			track.add(note4on);

			ShortMessage sm4off = new ShortMessage();
			sm4off.setMessage(SM_NOTE_OFF, SM_CHANNEL_PIANO, 60, 100);
			MidiEvent note4off = new MidiEvent(sm4off, 16);
			track.add(note4off);

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
