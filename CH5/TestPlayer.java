import java.util.Scanner;

public class TestPlayer{
	public static void main(String[] args){
		Field field = null;

		try{
			field = new Field(3, 7, 7);
			field.placeShips();
		}
		catch(Exception e){
			System.err.println("Program halted");
		}
		
			Player player = new Player();
			
			Scanner in = new Scanner(System.in);
			while(field.getShipNum() > 0){
				player.shoot(field, in);
			}
			in.close();
	}
}
