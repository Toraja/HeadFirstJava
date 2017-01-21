public class SlimConstructors{
	public static void main(String[] args){
		SlimConstructors sc = new SlimConstructors("String");
	}


	SlimConstructors(){
		System.out.println("This is the most important process. Every constructor needs it.");
	}

	SlimConstructors(int i){
		this();
		System.out.println("this is another constructor that takes int as an argument.");
		System.out.println("The value of the argument is " + i);
	}

	SlimConstructors(String s){
		this(3);
		System.out.println("this is another constructor that takes String as an argument.");
		System.out.println("The value of the argument is " + s);
	}
}
