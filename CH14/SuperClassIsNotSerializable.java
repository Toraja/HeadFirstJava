import java.io.*;

public class SuperClassIsNotSerializable /*implements Serializable*/{
	int num;
	String name;

	// default (no-arg) constructor is needed when Serializable subclass is deserialized.
	// Exception will be thrown if the does not exist.
	SuperClassIsNotSerializable(){
		// this.num = 1;
		// this.name = "John";
	}

	SuperClassIsNotSerializable(int num, String name){
		this.num = num;
		this.name = name;
	}

	public void introduce(){
		System.out.println("Hi, my name is " + this.name + ", and the number is " + num + ".");
	}
	public static void main(String[] args){
		SubClassIsSerializable scis = new SubClassIsSerializable(3, "Edward");
		scis.introduce();
		try{
			FileOutputStream fos = new FileOutputStream("SuperClassIsNotSerializable.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(scis);
			oos.close();

			FileInputStream fis = new FileInputStream("SuperClassIsNotSerializable.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			SubClassIsSerializable newScis = (SubClassIsSerializable)ois.readObject();
			ois.close();

			newScis.introduce();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

class SubClassIsSerializable extends SuperClassIsNotSerializable implements Serializable{
	// constructor is not called as it's restoring, not initializing
	SubClassIsSerializable(){
		super(4, "Stuwart");
	}

	SubClassIsSerializable(int num, String name){
		super(num, name);
	}
}
