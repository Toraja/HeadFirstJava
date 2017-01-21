public abstract class StaticMethodInAbstractClass{
	public static void main(String[] args){
		AbstractClass.abstaticMethod();
	}
}

abstract class AbstractClass{
	static void abstaticMethod(){
		System.out.println("this is a method in an abstract class.");
	}
}
