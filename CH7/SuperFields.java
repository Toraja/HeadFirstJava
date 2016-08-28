/**
 * check how changing fields of super class affects
 * set super fields from a few different sub classes and see what happens
 * for static var, do this.staticvar and ClassName.staticvar in any way?
 */

public class SuperFields{
	public static void main(String[] args){
		SubClass sc = new SubClass();
	}
}

abstract class SuperClass{
	int instIntVar;
	static int statIntVar;

	void displayThisVarInSuper(){
		System.out.print("displayThisVarInSuper was called >>> ");
		System.out.print("instIntVar: " + this.instIntVar);
		System.out.print(", ");
		System.out.println("statIntVar: " + this.statIntVar);
	}

	// this instIntVar getter
	public int getThisInstIntVarInSuper(){
		return this.instIntVar;
	}

	// this instIntVar setter
	public void setThisInstIntVarInSuper(int instIntVar){
		this.instIntVar = instIntVar;
	}

	// this statIntVar getter
	public int getThisStatIntVarInSuper(){
		return this.statIntVar;
	}

	// this statIntVar setter
	public void setThisStatIntVarInSuper(int statIntVar){
		this.statIntVar = statIntVar;
	}

}

class SubClass extends SuperClass{
	// this getter
	public int getThisInstIntVarInSub(){
		return this.instIntVar;
	}

	// this setter
	public void setThisStatIntVarInSub(int statIntVar){
		this.statIntVar = statIntVar;
	}

	// super getter
	public int getSuperInstIntVar(){
		return this.instIntVar;
	}

	// super setter
	public void setSuperStatIntVar(int statIntVar){
		this.statIntVar = statIntVar;
	}

	void displayThisVarInSub(){
		System.out.print("displayThisVarInSub was called >>> ");
		System.out.print("instIntVar: " + this.instIntVar);
		System.out.print(", ");
		System.out.println("statIntVar: " + this.statIntVar);
	}

	void displaySuperVarInSub(){
		System.out.print("displaySuperVarInSub was called >>> ");
		System.out.print("instIntVar: " + this.instIntVar);
		System.out.print(", ");
		System.out.println("statIntVar: " + this.statIntVar);
	}

}
