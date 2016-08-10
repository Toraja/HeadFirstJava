public class PointerValue{
	public static void main(String[] args){
		Sparrow sp1 = new Sparrow();
		Sparrow sp2 = new Sparrow();
		Sparrow sp3 = sp1;
		Sparrow sp4 = sp3;
		Sparrow sp5 = null;

		System.out.println("new sparrow 1: " + sp1.toString());
		System.out.println("new sparrow 2: " + sp2.toString());
		System.out.println("copy of sparrow 1: " + sp3.toString());
		System.out.println("copy of copy of sparrow 1: " + sp4.toString());
		System.out.println("null reference: " + sp5);
	}
}

class Sparrow{
	// just a class
}
