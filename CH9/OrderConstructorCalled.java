public class OrderConstructorCalled{
	public static void main(String[] args){
		Bottom b = new Bottom();
	}
}

class Top{
	public Top(){
		System.out.println("Hello from Top");
	}
}

class Middle extends Top{
	public Middle(){
		System.out.println("Hello from Middle");
	}
}

class Bottom extends Middle{
	public Bottom(){
		System.out.println("Hello from Bottom");
	}
}
