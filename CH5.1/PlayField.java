import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class PlayField{
	private int fieldLength;
	private int fieldWidth;
	private int shipNum;
	private Map<Integer, ShipComponent> shipLocation;
	
	private enum Direction{
		Noway(0), Up(1), Down(2), Right(3), Left(4);
		
		int value;
		
		Direction(int value){
			this.value = value;
		}
	}
	
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
					
					if (isPlacable(locationNum)){
						break;
					}
				}
				
				Direction direction = directShip(locationNum, shipSizeToCreate);
				
				placeShipComponents(ship, locationNum, direction, shipSizeToCreate);
			}
			
		}
		
	}
	
	private int getRandomLocNum(){
		int x = (int)(Math.random() * fieldWidth) + 1;
		int y = (int)(Math.random() * fieldLength) + 1;
		int locNum  = (y * fieldWidth + x);
		
		return locNum;
	}
	
	private boolean isPlacable(int locNum){
		return !shipLocation.containsKey(locNum);	
	}
	
	private Direction directShip(int locNum, Ship.ShipSize shipSize){
		// TODO implement
		return null;
	}
	
	private void placeShipComponents(Ship ship, int locNum, Direction direction, Ship.ShipSize shipSize){
		// TODO implement
	}
}
