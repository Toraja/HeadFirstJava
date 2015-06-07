/*					completed 
PlayField
getShipNum			yes
getFieldLength		yes
getFieldWidth		yes
getShipOnLocNum		yes
placeShips			yes
removeShip			yes
decrementShipNum	yes
getRandomLocNum		yes
isPlaceable			yes
directShip			yes
checkOnTheEdge		yes
checkShipOnTheWay	yes
buildShip			yes	
getIncIdx			yes
 */
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class PlayField{
	private int fieldLength;
	private int fieldWidth;
	private int shipNum;
	private Map<Integer, Ship> shipLocation = new HashMap<Integer, Ship>();
	
	enum Direction{
		Up(1), Down(2), Right(3), Left(4);
		
		int value;
		
		Direction(int value){
			this.value = value;
		}
	}

	public PlayField(int fieldLength, int fieldWidth, int shipNum, ArrayList<Ship> shipList){
		this.fieldLength = fieldLength;
		this.fieldWidth = fieldWidth;
		this.shipNum = shipNum;

		this.placeShips(shipList);

		System.out.println("There are " + shipNum + "ships on the field.");
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
	
 	
	private void placeShips(ArrayList<Ship> shipList){
		for(Ship ship : shipList){
			boolean shipCreated = false;
			while(!shipCreated){
				int locNum = this.getRandomLocNum();
				if(!this.isPlaceable(locNum)){
					continue;
				}

				Direction direction = this.directShip(locNum, ship.getSize());
				
				if(direction == null){
					continue;
				}
				
				this.buildShip(ship, locNum, direction);
				shipCreated = true;
			}
		}
	}
 
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
	
	/**
	 * Returns a Direction for a ship to be build along
	 * Returns null if no direction is available
	 */
	private Direction directShip(int locNum, Ship.ShipSize shipSize){
		Direction shipDirection = null;
		ArrayList<Direction> availableDirections = checkOnTheEdge(locNum, shipSize);
		checkShipOnTheWay(locNum, shipSize, availableDirections);

		if(availableDirections.size() > 1){
			shipDirection = availableDirections.get(SinkADotCom.getRandomIntUpTo(availableDirections.size() - 1));
		}
		else if(availableDirections.size() == 1){
			shipDirection = availableDirections.get(0);
		}
		
		return shipDirection;
	}
	
	private ArrayList<Direction> checkOnTheEdge(int locNum, Ship.ShipSize shipSize){
		ArrayList<Direction> availableDirections = new ArrayList<Direction>();
		
		int x = (locNum % this.fieldWidth == 0) ? this.fieldWidth : locNum % this.fieldWidth;
		int y = (locNum % this.fieldWidth == 0) ? locNum / this.fieldWidth : (int)(locNum / this.fieldWidth) + 1;
		
		// check upper edge
		if(y >= shipSize.getHpOfSize()) availableDirections.add(Direction.Up);
		
		// check lower edge
		if(this.fieldLength - (y - 1) >= shipSize.getHpOfSize()) availableDirections.add(Direction.Down);

		//check right edge
		if(this.fieldWidth - (x - 1) >= shipSize.getHpOfSize()) availableDirections.add(Direction.Right);
		
		// check left edge
		if(x >= shipSize.getHpOfSize()) availableDirections.add(Direction.Left);
		
		return availableDirections;
	}
	
	/**
	 * Checks for each given direction whether any ship exists within the area
	 * the ship might be built in
	 * Modify the given direction list (availableDirections) and limit the directions
	 * only to ones that are free to build
	 * availableDirections will be empty if no direction is available
	 */
	private void checkShipOnTheWay(int locNum, Ship.ShipSize shipSize, ArrayList<Direction> availableDirections){
		ArrayList<Direction> iterationList = new ArrayList<Direction>();
		iterationList.addAll(availableDirections);
		for(Direction direction : iterationList){
			int idx = getIncIdx(direction);
			for(int i  = 1; i < shipSize.getHpOfSize(); i++){
				int locNumToCheck = locNum + i * idx;
				if(!isPlaceable(locNumToCheck)){
					availableDirections.remove(direction);
					break;
				}
			}
		}
	}

	private void buildShip(Ship ship, int locNum, Direction direction){
		int idx = getIncIdx(direction);
		for(int i = 0; i < ship.getSize().getHpOfSize(); i++){
			shipLocation.put(locNum + i * idx, ship);
		}
	}
	private int getIncIdx(Direction direction){
		int idx = 1;
		switch(direction){
			case Up:
				idx = (-1 * this.fieldWidth);
				break;
			case Down:
				idx = this.fieldWidth;
				break;
			case Left:
				idx = -1;
				break;
			case Right:
				break;
		}
		return idx;
	}
}
