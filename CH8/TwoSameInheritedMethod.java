public class TwoSameInheritedMethod{
	public static void main(String[] args){
		SubDuck sd = new SubDuck();
		sd.getMyDuckness();
		ExtendedDuck ed = new ExtendedDuck();
		ed.getMyDuckness();
	}
}

class SuperDuck{
	int duckness = 5;

	public void getMyDuckness(){
		System.out.println("My duckness is " + this.duckness);
	}
}

interface PetDuck{
	int duckness = 2;

	void getMyDuckness();
}

class SubDuck extends SuperDuck implements PetDuck{
	int x = 0;

	// @Override
	// public void getMyDuckness(){
		// System.out.println("My sub duckness is " + this.duckness);
	// }
}

class ExtendedDuck extends SuperDuck implements PetDuck{
	int x = 0;
	// int duckness = 4;

	@Override
	public void getMyDuckness(){
		// System.out.println("My extended duckness is " + this.duckness); << this.duckness gets complained as it's umbigous
		System.out.println("My PetDuck's duckness is " + PetDuck.duckness);
		System.out.println("My SuperDuck's duckness is " + super.duckness);
	}
}
