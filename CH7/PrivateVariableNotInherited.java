public class PrivateVariableNotInherited{
	public static void main(String[] args){
		PrivateVariableNotInherited pvni = new PrivateVariableNotInherited();
		pvni.sub();
	}

	public void sub(){
		SubClass2 sc = new SubClass2();
		SubClass2 sc2 = new SubClass2();

		sc.setPrivateVar("PrivateVar");
		sc2.setPrivateVar("PrivateVar2");

		System.out.println(sc.getPrivateVar());
		System.out.println(sc2.getPrivateVar());
		// System.out.println(sc2.privateVar);	<<< compile time error
		sc2.protectedVar = "ProtectedVar";
		System.out.println(sc2.protectedVar);
	}


	abstract class SuperClass2{
		protected String protectedVar;
		private String privateVar;

		public String getPrivateVar(){
			return this.privateVar;
		}

		public void setPrivateVar(String privateVar){
			this.privateVar = privateVar;
		}
	}

	class SubClass2 extends SuperClass2{
		public String getPrivateVar(){
			return this.privateVar;
		}

		public void setPrivateVar(String privateVar){
			this.privateVar = privateVar;
		}
	}
}
