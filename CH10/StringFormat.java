import java.util.Date;

public class StringFormat{
	public static void main(String[] args){
		System.out.println(String.format("%5d", 123));
		// System.out.println(String.format("%6d", 123.0));		<<< not working because of decimal point
		System.out.println(String.format("%,09.3f", 123.0));
		// System.out.println(String.format("%,09.3f", 123));	<<< not working because of no decimal point
		System.out.println(String.format("%c", 'a'));
		System.out.println(String.format("%c", 66));
		System.out.println(String.format("%05d %<c", 99));

		System.out.println(String.format("%tA %<tB %<td", new Date()));
	}
}
