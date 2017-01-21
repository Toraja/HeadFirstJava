public class StaticInheritedMethod{
	public static void main(String[] args){
		SubClass.subMethod();
	}
}

class SuperClass{
	static{
		System.out.println("static close of SuperClass");
	}

	static void superMethod(){
		System.out.println("This is a super method.");
	}
}

class SubClass{
	static{
		System.out.println("static close of SubClass");
	}

	static void subMethod(){
		SuperClass.superMethod();
		System.out.println("This is a sub method");
	}
}
