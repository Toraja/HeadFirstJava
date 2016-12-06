/**
 * Check what exactly setting inherited static fields does
 * Set inherited static fields from a few different sub classes
 * and see the change affects outside the class
 */

public class SuperStaticFields{
	public static void main(String[] args){

		SubClass1 sub1 = new SubClass1();
		SubClass2 sub2 = new SubClass2();
		int cnt = 0;
		int casenum = 0;

		// intro
		System.out.println("### case " + ++casenum + " ###");
		System.out.println("- Set different value to inherited static variable of each sub class");
		System.out.println("  using inherited setter and see they are independent to each other");
		// experiment
		sub1.setThisStatIntVarInSuper(++cnt);
		System.out.println("Run sub1.setThisStatIntVarInSuper(" + cnt + ")");
		System.out.println("sub1 super static variable: " + sub1.getThisStatIntVarInSuper());
		System.out.println("sub2 super static variable: " + sub2.getThisStatIntVarInSuper());
		sub2.setThisStatIntVarInSuper(++cnt);
		System.out.println("Run sub2.setThisStatIntVarInSuper(" + cnt + ")");
		System.out.println("sub1 super static variable: " + sub1.getThisStatIntVarInSuper());
		System.out.println("sub2 super static variable: " + sub2.getThisStatIntVarInSuper());
		// conclusion
		System.out.println("=> Inherited static varialbes are shared with all child classes.");

		System.out.println("-----------------------------------------");

		// intro
		System.out.println("### case " + ++casenum + " ###");
		System.out.println("- Set different value to inherited static variable of each sub class");
		System.out.println("  using the class's setter and see they are independent to each other");
		// experiment
		sub1.setThisStatIntVarInSuper(++cnt);
		System.out.println("Run sub1.getThisStatIntVarInSub(" + cnt + ")");
		System.out.println("sub1 this static variable: " + sub1.getThisStatIntVarInSub());
		System.out.println("sub2 this static variable: " + sub2.getThisStatIntVarInSub());
		System.out.println("sub1 super static variable: " + sub1.getSuperStatIntVar());
		System.out.println("sub2 super static variable: " + sub2.getSuperStatIntVar());
		sub2.setThisStatIntVarInSuper(++cnt);
		System.out.println("Run sub2.getThisStatIntVarInSub(" + cnt + ")");
		System.out.println("sub1 this static variable: " + sub1.getThisStatIntVarInSub());
		System.out.println("sub2 this static variable: " + sub2.getThisStatIntVarInSub());
		System.out.println("sub1 super static variable: " + sub1.getSuperStatIntVar());
		System.out.println("sub2 super static variable: " + sub2.getSuperStatIntVar());
		// conclusion
		System.out.println("=> Setting this.staticVariable also means setting super.staticVariable");
		System.out.println("=> Inherited static varialbes are shared with all child classes.");

		System.out.println("-----------------------------------------");

		// *** class's own static field ***
		// intro
		System.out.println("### case " + ++casenum + " ###");
		System.out.println("- Set values different from super's static to class's own static variable which has the same name");
		System.out.println("  using the class's setter and see they are independent to each other");
		// experiment
		sub1.setOwnStatIntVar(++cnt);
		System.out.println("Run sub1.setOwnStatIntVar(" + cnt + ")");
		System.out.println("sub1 own static variable: " + sub1.getOwnStatIntVar());
		System.out.println("sub2 own static variable: " + sub2.getOwnStatIntVar());
		System.out.println("sub1 this static variable: " + sub1.getThisStatIntVarInSub());
		System.out.println("sub2 this static variable: " + sub2.getThisStatIntVarInSub());
		System.out.println("sub1 super static variable: " + sub1.getSuperStatIntVar());
		System.out.println("sub2 super static variable: " + sub2.getSuperStatIntVar());
		sub2.setOwnStatIntVar(++cnt);
		System.out.println("Run sub2.setOwnStatIntVar(" + cnt + ")");
		System.out.println("sub1 own static variable: " + sub1.getOwnStatIntVar());
		System.out.println("sub2 own static variable: " + sub2.getOwnStatIntVar());
		System.out.println("sub1 this static variable: " + sub1.getThisStatIntVarInSub());
		System.out.println("sub2 this static variable: " + sub2.getThisStatIntVarInSub());
		System.out.println("sub1 super static variable: " + sub1.getSuperStatIntVar());
		System.out.println("sub2 super static variable: " + sub2.getSuperStatIntVar());
		// conclusion
		System.out.print("=> Static variable defined in a class are independent to the one of super");
		System.out.println(" even though they are the same name");

		System.out.println("-----------------------------------------");

		// overall conclusion
		System.out.println("### Summary ###");
		System.out.println("* Inherited static variables are shared with all subclasses, even though they are different type.");
		System.out.println("* Setting this.inheritedStaticVariable also means setting super.staticVariable.");
		System.out.println("  this indicates that this.inheritedStaticVariable points to super class's variable.");
		System.out.println("* Static variables defined in a class are independent to the one of super");
		System.out.println("  even though they are the same name.");
		System.out.println("  In that case, this.var points to the class's own variable,");
		System.out.println("  while super.var points to the super's variable of the name.");
	}
}

abstract class SuperClass{
	int instIntVar;
	static int statIntVar;

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

class SubClass1 extends SuperClass{
	static int statIntVar;

	public int getOwnStatIntVar(){
		return this.statIntVar;
	}

	public void setOwnStatIntVar(int statIntVar){
		this.statIntVar = statIntVar;
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

	// super Inst getter
	public int getSuperInstIntVar(){
		return super.instIntVar;
	}

	// super Inst setter
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

}

class SubClass2 extends SuperClass{
	static int statIntVar;

	public int getOwnStatIntVar(){
		return this.statIntVar;
	}

	public void setOwnStatIntVar(int statIntVar){
		this.statIntVar = statIntVar;
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

	// super Inst getter
	public int getSuperInstIntVar(){
		return super.instIntVar;
	}

	// super Inst setter
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

}
