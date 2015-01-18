//import java.util.Arrays;

public class TwoDArray{
	public static void main(String[] args){
		String[][] array1 = {
			{"A1","A2","A3","A4"},
			{"B1","B2","B3","B4"}
		};
		System.out.println(array1.length);
		System.out.println(array1[0].length);
		
		String[][] array2 = new String[2][4];
		System.out.println(array2.length);
		System.out.println(array2[0].length);
	}
}
