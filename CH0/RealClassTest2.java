class RealClass2 {
	public static void main(String[] args){
		System.out.println("I'm main!");
	}
	
	String st = "Real";
	
	public void claim(){
		System.out.println("I'm " + st);
	}
}

public class RealClassTest2{
	public static void main(String[] args){
		RealClass2 real = new RealClass2();
		
		String[] stArr = {"a","b"};
		
		real.claim();
		real.main(stArr);
	}
}