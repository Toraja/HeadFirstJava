class RealClass {
	String st = "Real";
	
	public void claim(){
		System.out.println("I'm " + st);
	}
}

public class RealClassTest{
	public static void main(String[] args){
		RealClass real = new RealClass();
		
		real.claim();
	}
}