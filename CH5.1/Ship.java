//					completed
//getHpOfSize		yes
//Ship				yes
//getName			yes
//getHp				yes
//getSize			yes
//initShips			
//getRandomShipName	yes

import java.util.ArrayList;
import java.util.Arrays;

public class Ship{
	private String name;
	private int hp;
	private ShipSize size;
	
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
	
	private Ship(ShipSize size, ArrayList<String> shipNameList){
		this.size = size;
		this.name = getRandomShipName(shipNameList);
		this.hp = size.getHpOfSize();
	}
	
	public String getName(){
		return this.name;
	}

	public int getHp(){
		return this.hp;
	}

	public ShipSize getSize(){
		return this.size;
	}
	
	public static ArrayList<Ship> initShips(int totalShipNum){
		ArrayList<String> shipNameList = new ArrayList<String>(Arrays.asList("Google.com", "Facebood.com", "Instagram.com", "Spotify.com", "Amazon.com", "YouTube.com", "Twitter.com", "Kickstarter.com", "Evernote.com")); 
		ArrayList<Ship> shipList = new ArrayList<Ship>();
		int createdShipNum = 0;
		int shipNumForSize = 0;
		
		for(ShipSize shipSize : ShipSize.values()){
			shipNumForSize = SinkADotCom.getRandomIntUpTo(totalShipNum - createdShipNum);
			
			for(int i = 0; i < shipNumForSize; i++){
				shipList.add(new Ship(shipSize, shipNameList));
			}
		}
		
		
		return null;
	}
	
	private static String getRandomShipName(ArrayList<String> shipNameList){
		int index = SinkADotCom.getRandomIntUpTo(shipNameList.size() - 1);
		String shipName = shipNameList.get(index);
		shipNameList.remove(index);

		return shipName;
	}
	
}
