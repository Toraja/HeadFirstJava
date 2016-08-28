public class CompareObjects{
	public static void main(String[] args){
		// compare strings
		String st1 = "aaa";
		String st2 = "aaa";
		String st3 = new String("aaa");
		System.out.println((st1 == st2) ? "st1 == st2" : "st1 != st2");
		System.out.println((st1 == st3) ? "st1 == st3" : "st1 != st3");
		System.out.println((st1.equals(st3)) ? "st1 equals st3" : "st1 NOT equals st3");

		// compare objects
		AnObject ob1 = new AnObject();
		AnObject ob2 = new AnObject();
		System.out.println((ob1.equals(ob2)) ? "ob1 equals ob2" :  "ob1 NOT equals ob2");

		// compare wrapper object
		Integer int1 = 1;
		Integer int2 = 1;
		Integer int3 = new Integer(1);
		System.out.println((int1 == int2) ? "int1 == int2" : "int1 != int2");
		System.out.println((int1 == int3) ? "int1 == int3" : "int1 != int3");
		System.out.println((int1.equals(int3)) ? "int1 equals int3" : "int1 NOT equals int3");
		System.out.println((int1 == int3.intValue()) ? "int1 == int3.intValue()" : "int1 != int3.intValue()");
		System.out.println("int1: " + int1 + ", " + "int2: " + int2 + ", " + "int3: " + int3);
		System.out.println("int1: " + int1.SIZE + ", " + "int2: " + int2.SIZE + ", " + "int3: " + int3.SIZE);
		System.out.println("int1: " + int1.TYPE + ", " + "int2: " + int2.TYPE + ", " + "int3: " + int3.TYPE);
	}
}

class AnObject{
	int i = 9;
}
