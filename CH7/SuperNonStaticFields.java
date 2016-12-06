/**
 * Check if inherited fields are unique to an object
 * Set inherited non-static fields from a few different sub classes
 * and display the value of the fields
 */

public class SuperNonStaticFields{
	public static void main(String[] args){
		SubClass sub1 = new SubClass();
		SubClass sub2 = new SubClass();
		int cnt = 0;
		int casenum = 0;

		// *** Instance variable ***
		// intro - set this from sub
		System.out.println("### case " + ++casenum + " ###");
		System.out.println("- Set different value to inherited instance variable of each sub class");
		System.out.println("- using the class's setter and see they are independent to each other");
		// experiment
		sub1.setThisInstIntVarInSub(++cnt);
		System.out.println("Run sub1.setThisInstIntVarInSub(" + cnt + ")");
		System.out.println("sub1 this instance variable: " + sub1.getThisInstIntVarInSub());
		System.out.println("sub2 this instance variable: " + sub2.getThisInstIntVarInSub());
		System.out.println("sub1 super instance variable: " + sub1.getSuperInstIntVar());
		System.out.println("sub2 super instance variable: " + sub2.getSuperInstIntVar());
		sub2.setThisInstIntVarInSub(++cnt);
		System.out.println("Run sub2.setThisInstIntVarInSub(" + cnt + ")");
		System.out.println("sub1 this instance variable: " + sub1.getThisInstIntVarInSub());
		System.out.println("sub2 this instance variable: " + sub2.getThisInstIntVarInSub());
		System.out.println("sub1 super instance variable: " + sub1.getSuperInstIntVar());
		System.out.println("sub2 super instance variable: " + sub2.getSuperInstIntVar());
		// conclusion
		System.out.println("=> Inherited instance variables are unique to the object.");
		System.out.println("=> Setting this.instanceVariable also means setting super.instanceVariable");

		System.out.println("-----------------------------------------");

		// intro - set this from super
		System.out.println("### case " + ++casenum + " ###");
		System.out.println("- Set different value to inherited instance variable of each sub class");
		System.out.println("- using inherited setter and see they are independent to each other");
		// experiment
		sub1.setThisInstIntVarInSuper(++cnt);
		System.out.println("Run sub1.setThisInstIntVarInSuper(" + cnt + ")");
		System.out.println("sub1 this instance variable: " + sub1.getThisInstIntVarInSuper());
		System.out.println("sub2 this instance variable: " + sub2.getThisInstIntVarInSuper());
		System.out.println("sub1 super instance variable: " + sub1.getSuperInstIntVar());
		System.out.println("sub2 super instance variable: " + sub2.getSuperInstIntVar());
		sub2.setThisInstIntVarInSuper(++cnt);
		System.out.println("Run sub2.setThisInstIntVarInSuper(" + cnt + ")");
		System.out.println("sub1 this instance variable: " + sub1.getThisInstIntVarInSuper());
		System.out.println("sub2 this instance variable: " + sub2.getThisInstIntVarInSuper());
		System.out.println("sub1 super instance variable: " + sub1.getSuperInstIntVar());
		System.out.println("sub2 super instance variable: " + sub2.getSuperInstIntVar());
		// conclusion
		System.out.println("=> Using inherited setter and class's own setter makes no difference.");

		System.out.println("-----------------------------------------");

		// intro - set super from sub
		System.out.println("### case " + ++casenum + " ###");
		System.out.println("- Set different value to super(abstract)'s instance variable");
		System.out.println("- and see how that affects instance var in super and sub");
		// experiment
		sub1.setSuperInstIntVar(++cnt);
		System.out.println("Run sub1.setSuperInstIntVar(" + cnt + ")");
		System.out.println("sub1 super instance variable: " + sub1.getSuperInstIntVar());
		System.out.println("sub2 super instance variable: " + sub2.getSuperInstIntVar());
		System.out.println("sub1 this instance variable: " + sub1.getThisInstIntVarInSub());
		System.out.println("sub2 this instance variable: " + sub2.getThisInstIntVarInSub());
		sub2.setSuperInstIntVar(++cnt);
		System.out.println("Run sub2.setSuperInstIntVar(" + cnt + ")");
		System.out.println("sub1 super instance variable: " + sub1.getSuperInstIntVar());
		System.out.println("sub2 super instance variable: " + sub2.getSuperInstIntVar());
		System.out.println("sub1 this instance variable: " + sub1.getThisInstIntVarInSub());
		System.out.println("sub2 this instance variable: " + sub2.getThisInstIntVarInSub());
		// conclusion
		System.out.println("=> Setting super.instanceVariable also means this.instanceVariable.");

		System.out.println("-----------------------------------------");

		// overall conclusion
		System.out.println("### Summary ###");
		System.out.println("Instance variable is unique to its object");
		System.out.println("super.instanceVariable is same as this.instanceVariable");
	}
}

abstract class SuperClass{
	int instIntVar;
	static int statIntVar;

	void displayThisVarInSuper(String name){
		System.out.print(name + "'s displayThisVarInSuper was called >>> ");
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
	static int newStatIntVar;

	public int getNewStatIntVar(){
		return this.newStatIntVar;
	}

	public void setNewStatIntVar(int newStatIntVar){
		this.newStatIntVar = newStatIntVar;
	}
	
	// this Inst getter
	public int getThisInstIntVarInSub(){
		return this.instIntVar;
	}

	// this Inst setter
	public void setThisInstIntVarInSub(int instIntVar){
		this.instIntVar = instIntVar;
	}

	// this Stat getter
	public int getThisStatIntVarInSub(){
		return this.statIntVar;
	}

	// this Stat setter
	public void setThisStatIntVarInSub(int statIntVar){
		this.statIntVar = statIntVar;
	}

	public int getSuperInstIntVar(){
		return super.instIntVar;
	}

	public void setSuperInstIntVar(int instIntVar){
		super.instIntVar = instIntVar;
	}

	// super Stat getter
	public int getSuperStatIntVar(){
		return super.statIntVar;
	}

	// super Stat setter
	public void setSuperStatIntVar(int statIntVar){
		super.statIntVar = statIntVar;
	}

	void displayThisVarInSub(String name){
		System.out.print(name + "'s displayThisVarInSub was called >>> ");
		System.out.print("instIntVar: " + this.instIntVar);
		System.out.print(", ");
		System.out.println("statIntVar: " + this.statIntVar);
	}

	void displaySuperVarInSub(String name){
		System.out.print(name + "'s displaySuperVarInSub was called >>> ");
		System.out.print("instIntVar: " + super.instIntVar);
		System.out.print(", ");
		System.out.println("statIntVar: " + super.statIntVar);
	}

}
