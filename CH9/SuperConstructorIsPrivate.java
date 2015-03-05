public class SuperConstructorIsPrivate {
	public static void main (String [] args){
		// Ancestor a = new Ancestor("David",	 9999);
		Descendant d = new Descendant("Steve", 100);
		d.sayMyName();
		d.sayMyAncestorName();
		d.howMuchDoIHave();
		d.inherit();
	}
}

class Ancestor {
	String name;
	int fortune;
	
	// private no-arg constructor could lead compile error
	/* 
	private Ancestor(){
		System.out.println("private Ancestor constructor");
	};
	 */
	/* 
	Ancestor(){
		System.out.println("private Ancestor constructor");
	};
	 */
	public Ancestor(String name, int fortune){
		this.name = name;
		this.fortune = fortune;
		System.out.println("public Ancestor constructor");
	}
	
	public void sayMyName(){
		System.out.println("I am " + this.name);
	}
	
	public void howMuchDoIHave(){
		System.out.println("I have " + this.fortune);
	}
	
	private void writeWill(){
		
	}
}

class Descendant extends Ancestor{
	String name;
	int fortune;
	
	Descendant(String name, int fortune){
		super("Joseph", 99999900);
		this.name = name;
		this.fortune = fortune;
		System.out.println("Descendant constructor");
	}
	
	@Override
	public void sayMyName(){
		System.out.println("My name is " + this.name);
	}
	
	public void sayMyAncestorName(){
		System.out.println("My ancestor's name is " + super.name);
	}
	
	@Override
	public void howMuchDoIHave(){
		System.out.println("I have " + this.fortune);
	}
	
	public void inherit(){
		this.fortune += super.fortune;
		System.out.println("I have received " + super.fortune);
		System.out.println("Now I have " + this.fortune);
	}
}