//			completed
//shoot		yes
//disarm	yes
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

class Player{
	private Scanner cannon = new Scanner(System.in);
	
	public String shoot() throws NoSuchElementException, IllegalStateException{
		System.out.println("Enter a coordinate");
		String coordinate = cannon.next();
		return coordinate;
	}
	
	public void disarm(){
		this.cannon.close();
	}
}
