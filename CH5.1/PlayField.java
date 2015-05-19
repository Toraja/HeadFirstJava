/*					completed 
PlayField
getShipNum			yes
getFieldLength		yes
getFieldWidth		yes
getShipOnLocNum		yes
placeShips
removeShip			yes
decrementShipNum	yes
getRandomLocNum		yes
isPlaceable			yes
directShip
checkOnTheEdge
checkShipOnTheWay
buildShip	
 */
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class PlayField{
	private int fieldLength;
	private int fieldWidth;
	private int shipNum;
	private Map<Integer, Ship> shipLocation;
	
	private enum Direction{
		Up(1), Down(2), Right(3), Left(4);
		
		int value;
		
		Direction(int value){
			this.value = value;
		}
	}
	
	public int getShipNum(){
		return this.shipNum;
	}

	public int getFieldLength(){
		return this.fieldLength;
	}

	public int getFieldWidth(){
		return this.fieldWidth;
	}
	
	private Ship getShipOnLocNum(int locNum){
		return shipLocation.get(locNum);
	}
	
/* 	
	private void placeShips(int totalShipNum){
//		ArrayList<Integer> locNumList = new ArrayList<Integer>();
		final int shipTypeNum = Ship.ShipSize.values().length; // 3
		int shipNumCreated = 0;
		
		// init each size of ship
		for(int i = 0; i < shipTypeNum; i++){
			Ship.ShipSize shipSizeToCreate = Ship.ShipSize.values()[i];
			int shipNumToCreate;
			
			if(i != (shipTypeNum - 1)){ // not the last size
				shipNumToCreate = SinkADotCom.getRandomIntUpTo(totalShipNum - shipNumCreated);
				shipNumCreated = shipNumCreated + shipNumToCreate;
			}
			else { // the last size
				shipNumToCreate = totalShipNum - shipNumCreated;
			}
			
			//	init ship for the size
			for(int j = 0; j < shipNumToCreate; j++){
				Ship ship = new Ship(shipSizeToCreate);
				int locationNum;
				
				while(true){ // get random location num until the location is empty
					locationNum = getRandomLocNum();
					
					if (isPlaceable(locationNum)){
						break;
					}
				}
				
				Direction direction = directShip(locationNum, shipSizeToCreate);
				
				buildShip(ship, locationNum, direction, shipSizeToCreate);
			}
			
		}
		
	}
 */	
 
	public void removeShip(int locNum){
		shipLocation.remove(locNum);
	}
	
	public void decrementShipNum(){
		this.shipNum--;
	}
	
	private int getRandomLocNum(){
		return (int)(Math.random() * (this.fieldLength * this.fieldWidth)) + 1;
	}
	
	private boolean isPlaceable(int locNum){
		return !shipLocation.containsKey(locNum);	
	}
	
	private Direction directShip(int locNum, Ship.ShipSize shipSize){
		// TODO implement
		return null;
	}
	
	private ArrayList<Direction> checkOnTheEdge(int locNum, Ship.ShipSize shipSize){
		// TODO implement
		return null;		
	}
	
	private void buildShip(Ship ship, int locNum, Direction direction, Ship.ShipSize shipSize){
		// TODO implement
	}
}
