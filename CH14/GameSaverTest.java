import java.io.*;

public class GameSaverTest{
	public static void main(String[] args){
		GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
		GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands", "big ax"});
		GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spell", "invisivility"});

		// imagine codes that does things with the characters that might change their state values

		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			oos.writeObject(one);
			oos.writeObject(two);
			oos.writeObject(three);
			oos.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}

		one = null;
		two = null;
		three = null;

		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Game.ser"));
			GameCharacter oneRestored = (GameCharacter)ois.readObject();
			GameCharacter twoRestored = (GameCharacter)ois.readObject();
			GameCharacter threeRestored = (GameCharacter)ois.readObject();

			System.out.println("One's type: " + oneRestored.getType());
			System.out.println("Two's type: " + twoRestored.getType());
			System.out.println("Three's type: " + threeRestored.getType());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}


