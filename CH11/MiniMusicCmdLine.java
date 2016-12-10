import javax.sound.midi.*;
import java.util.concurrent.TimeUnit;

public class MiniMusicCmdLine{
	static final int MSG_TYPE_NOTE_ON = 144;
	static final int MSG_TYPE_NOTE_OFF = 128;
	static final int MSG_TYPE_CHANGE_INST = 192;

	public static void main(String[] args){
		MiniMusicCmdLine mini = new MiniMusicCmdLine();
		if(args.length < 2){
			System.err.println("Don't forget the instrument and note args");
			return;
		}

		int instrument = Integer.parseInt(args[0]);
		int note = Integer.parseInt(args[1]);

		if(instrument < 0 || instrument > 127 || note < 0 || note > 127){
			System.err.println("Arguments must be an integer between 0 and 127");
		}

		mini.play(instrument, note);
	}

	public void play(int instrument, int note){
		try{
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			MidiEvent event = null;

			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);

			ShortMessage sm1 = new ShortMessage();
			sm1.setMessage(MSG_TYPE_NOTE_ON, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(sm1, 1);
			track.add(noteOn);

			ShortMessage sm2 = new ShortMessage();
			sm2.setMessage(MSG_TYPE_NOTE_OFF, 1, note, 100);
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
