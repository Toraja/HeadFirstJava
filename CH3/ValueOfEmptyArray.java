public class ValueOfEmptyArray{
	public static void main(String[] args){
		// int
		int[] intArr = new int[5];
		intArr[0] = 1;
		intArr[1] = 2;

		System.out.println("array of int");
		for(int i = 0; i < intArr.length; i++){
			System.out.println("i = " + i + ": " + intArr[i]);
		}
		System.out.println();

		// String
		String[] stringArr = new String[5];
		stringArr[0] = "Tom";
		stringArr[1] = "Paul";
		stringArr[2] = "Ron";
		stringArr[3] = "Frank";

		System.out.println("array of string");
		for(int i = 0; i < stringArr.length; i++){
			System.out.println("i = " + i + ": " + stringArr[i]);
		}
		System.out.println();

		// Frog
		Frog[] frogArr = new Frog[5];
		frogArr[0] = new Frog();
		frogArr[1] = new Frog();

		System.out.println("array of frog");
		for(int i = 0; i < frogArr.length; i++){
			System.out.println("i = " + i + ": " + frogArr[i]);
		}
		System.out.println();

		// turtle
		Turtle[] turtleArr = new Turtle[5];
		for(int i = 0; i < turtleArr.length; i++){
			turtleArr[i] = new Turtle(stringArr[i]);
		}
		System.out.println("array of turtle");
		for(int i = 0; i < turtleArr.length; i++){
			System.out.println(turtleArr[i].getName());
		}
	}
}

class Frog{
	// just a class
}

class Turtle{
	String name;

	Turtle(String name){
		this.name = name;
	}

	String getName(){
		return this.name;
	}
}
