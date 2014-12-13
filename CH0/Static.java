public class Static{
	public static void main(String[] args){
		mStatic.output();
	}

}

class mStatic{
	private static String staticVar = "static";
	private String nonStaticVar = "nonStatic";

	public static void output(){
		System.out.println(nonStaticVar);
	}
}