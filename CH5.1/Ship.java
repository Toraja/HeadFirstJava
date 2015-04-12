import java.util.ArrayList;

public class Ship{
	private String name;
	private int hp;
	private ShipSize size;
	private static ArrayList<String> shipNameList; // TODO static initializer
	
	public Ship(ShipSize size){
		this.size = size;
		this.name = getRandomShipName();
		this.hp = size.getHpOfSize();
	}
	
	public static enum ShipSize{
		Large(4), Mid(3), Small(2);
		
		int hp;
		
		ShipSize(int hp){
			this.hp = hp;
		}
		
		private int getHpOfSize(){
			return this.hp;
		}
	}
	
	public String getRandomShipName(){
		// TODO implement
		
		return "";
	}
	
}
