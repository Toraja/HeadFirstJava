public class PrivateSuperConstructor{
	public static void main(String[] args){
		// cannot instantiate as sub class cannot access its super class's constructor
		SubClass sb = new SubClass();
	}
}

class SuperClass{
	private SuperClass(){
		System.out.println("in the private super constructor");
	}
}

class SubClass extends SuperClass{
	SubClass(){
		System.out.println("in the sub class's constructor");
	}
}
