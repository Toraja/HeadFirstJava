import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class ReadObject{
	public static void main(String[] args){

		// Pig pinky = new Pig("pink", 45);
		// Pig boss = new Pig("black", 60);

		try{
			FileInputStream fis = new FileInputStream("SaveObject.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Pig fanky = (Pig)ois.readObject();
			ois.close();

			fanky.introduce();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

