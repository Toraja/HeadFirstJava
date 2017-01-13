/**
 * Inner class cannot be instantiated in static method in outer class
 * Inner class must belong to an outer class, so in that case,
 * it does not know which outer class the inner class belongs to.
 */
public class BondBtwOuterInnerClass{

	int mynumber;

	BondBtwOuterInnerClass(int x){
		this.mynumber = x;
	}

	public static void main(String[] args){

		BondBtwOuterInnerClass b1 = new BondBtwOuterInnerClass(3);
		BondBtwOuterInnerClass b2 = new BondBtwOuterInnerClass(8);

		b1.yo('a');
		b2.yo('g');
	}

	void yo(char c){

		Inner i = new Inner(c);
		i.hello();
		System.out.println("Hola from Outer class. My inner's char is " + i.mychar);
	}

	class Inner{
		char mychar;

		Inner(char c){
			this.mychar = c;
		}

		void hello(){
			System.out.println("Hello from Inner class. My outer's number is " + mynumber);
		}
	}
}
