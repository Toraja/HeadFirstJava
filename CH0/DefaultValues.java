public class DefaultValues{
	public static void main(String[] args){
		Aclass acl = new Aclass();
		System.out.println("char: " + acl.c);
		System.out.println("byte: " + acl.b);
		System.out.println("int: " + acl.i);
		System.out.println("double: " + acl.d);
	}
}

class Aclass{
	char c;
	byte b;
	int i;
	double d;
}
