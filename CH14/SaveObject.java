import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

public class SaveObject{
	public static void main(String[] args){

		Pig pinky = new Pig("pinky", "pink", 45);
		// Pig boss = new Pig("black", 60);

		try{
			FileOutputStream fos = new FileOutputStream("SaveObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(pinky);
			oos.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

class Pig implements Serializable{
	String name;
	String color;
	int weight;

	Pig(String name, String color, int weight){
		this.name = name;
		this.color = color;
		this.weight = weight;
	}

	public String  getName(){
		return this.name;
	}

	public void setName(String  name){
		this.name = name;
	}


	public String  getColor(){
		return this.color;
	}

	public void setColor(String  color){
		this.color = color;
	}

	public int  getWeight(){
		return this.weight;
	}

	public void setWeight(int  weight){
		this.weight = weight;
	}

	void introduce(){
		System.out.println("My name is " + this.name + ". I have " + this.weight + "kg of weight.");
	}
}
