import java.util.Scanner;

public class TryScanner{
	public static void main(String[] args){
		System.err.println("Enter something");
		Scanner in = new Scanner(System.in);
		String s = in.next();
		System.out.println(s);
		in.close();
	}
}