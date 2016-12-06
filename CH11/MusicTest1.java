import javax.sound.midi.*;

public class MusicTest1{

	public void play(){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
		}
		catch(MidiUnavailableException e){
			System.out.println("Failed to init MIDI player");
		}

		System.out.println("Bummer");
	}

	public static void main(String[] args){
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}
}
