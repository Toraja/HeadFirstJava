import java.lang.Integer;

public class PremitiveOverflow{
	public static void main(String[] args){
		int maxPlusOne = Integer.MAX_VALUE + 1;
		int minMinusOne = Integer.MIN_VALUE - 1;

		System.out.println("Max + 1 = " + (maxPlusOne) + " is equal to MIN_VALUE >> " + ((maxPlusOne == Integer.MIN_VALUE) ? "true" : "false"));
		System.out.println("Min - 1 = " + (minMinusOne) + " is equal to MAX_VALUE >> " + ((minMinusOne == Integer.MAX_VALUE) ? "true" : "false"));

		// this causes compile
		// byte maxBytePlusOne = 127 + 1;
		// System.out.println(maxBytePlusOne);
	}
}
