public class ObjectToString{
	public static void main(String[] args){
		AnObject anObject = new AnObject();
		//both outputs the same result
		System.out.println(anObject);
		System.out.println(anObject.toString());
	}
}

class AnObject{
	String name;
}
