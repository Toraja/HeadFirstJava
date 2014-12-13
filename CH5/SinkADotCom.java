import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class SinkADotCom {
    public static void main(String[] args){
    // TODO add code here
	
	// construct Field with num of ships and the size of field
	Field field = new Field(3, 7, 7);
	
    }
}

class Ship{
    private String name;
    private int shipHP;
	private ShipInfo.ShipSize shipSizeType;
	
	public Ship(String name, ShipInfo.ShipSize shipSizeType){
		this.name = name;
		this.shipSizeType = shipSizeType;
		// ship size and ship HP are same
		this.shipHP = ShipInfo.getShipHP(shipSizeType);
	}
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setShipHP(int shipHP){
        this.shipHP = shipHP;
    }
    public int getShipHP(){
        return this.shipHP;
    }
	
	public void setshipSizeType(ShipInfo.ShipSize shipSizeType){
		this.shipSizeType = shipSizeType;
	}
	public ShipInfo.ShipSize getshipSizeType(){
		return this.shipSizeType;
	}

}

class ShipComponent {
    Ship parentShip;
	
	public ShipComponent(Ship parentShip){
		this.parentShip = parentShip;
	}
	
	public void setParentShip(Ship parentShip){
			this.parentShip = parentShip;
	}
	public Ship getParentShip(){
			return this.parentShip;
	}
}

class ShipInfo{
	private static String shipNames[] = {"Google.com","Facebook.com","Apple.com","Microsoft.com","Linux.com","Dropbox.com","Mozilla.com","Wikipedia.com","Youtube.com","Twitter.com"};
	private static boolean shipNamesAssigned[] = {false,false,false,false,false,false,false,false,false,false};
	private static int smallShipHP = 2;
	private static int midShipHP = 3;
	private static int largeShipHP = 4;
	public static final int SMALL = 1;
	public static final int MID = 2;
	public static final int LARGE = 3;
	public enum ShipSize {SMALL, MID, LARGE};

	public static void setShipNames(String shipName, int index){
		shipNames[index] = shipName;
	}
	public static String getShipNames(int index){
		return shipNames[index];
	}
	
	public static void setShipNamesAssigned(boolean Assigned, int index){
		shipNamesAssigned[index] = Assigned;
	}
	public static boolean getShipNamesAssigned(int index){
		return shipNamesAssigned[index];
	}

	public static void setSmallShipHP(int HP){
		smallShipHP = HP;
	}
	public static int getSmallShipHP(){
		return smallShipHP;
	}

	public static void setMidShipHP(int HP){
		midShipHP = HP;
	}
	public static int getMidShipHP(){
		return midShipHP;
	}

	public static void setLargeShipHP(int HP){
		largeShipHP = HP;
	}
	public static int getLargeShipHP(){
		return largeShipHP;
	}
	
	public static String getRandomShipNames(){
		int index;
		do{
			index = (int)Math.floor(Math.random()*shipNames.length);
		}while(!shipNamesAssigned[index]);
		shipNamesAssigned[index] = true;
		return shipNames[index];
	}
	
	public static int getShipHP(ShipSize shipSize){
		int HP = 0;
		switch(shipSize){
		case SMALL:
			HP = smallShipHP;
			break;
		case MID:
			HP = midShipHP;
			break;
		case LARGE:
			HP = largeShipHP;
			break;
		}
		return HP;	
	}
}

class Field {
    private int shipNum;
	private int fieldLength;
	private int fieldWidth;
	private Ship[] ships;
    private ShipComponent[][] shipLocation = new ShipComponent[fieldLength][fieldWidth];
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int RIGHT = 3;
    private static final int LEFT = 4;
    private enum Direction {UP, DOWN, RIGHT, LEFT};
    
	public Field(int shipNum, int fieldLength, int fieldWidth){
		this.shipNum = shipNum;
		this.fieldLength = fieldLength;
		this.fieldWidth = fieldWidth;
		
		// initiate an array for parentShips
		ships = new Ship[shipNum];
		// put ships in the array
		for(int i = 0; i < this.shipNum; i++){
			// initiate ships
			ships[i] = new Ship(ShipInfo.getRandomShipNames(), ShipInfo.ShipSize.MID);
		}
	}

    public void setShipNum(int num){
        this.shipNum = num;
    }
    public int getShipNum(){
        return this.shipNum;
    }
    
	public void setShipLocation(ShipComponent shipComponent, int x, int y){
        this.shipLocation[x][y] = shipComponent;
	}
	public ShipComponent getShipLocation(int x, int y){
		return this.shipLocation[x][y];
	}
	
	// TODO create method initField()
    public void initField(){
        int startPointX;
        int startPointY;
		int[][] shipCoordinates; // first row: x, second row: y
	
        // create 3 sets of ship component
        for (int i = 0; i < this.shipNum; i++){
            // generate 3 pair of random number
			int shipHP = this.ships[i].getShipHP();
			shipCoordinates = new int[2][shipHP];
            startPointX = (int)Math.floor(Math.random()*fieldWidth);
            startPointY = (int)Math.floor(Math.random()*fieldLength);
				
			switch(directShip(startPointX, startPointY, shipHP)){
			case UP:
				for(int j = 0; j < shipHP; j++){
					shipCoordinates[0][j] = startPointX;
					shipCoordinates[1][j] = startPointY - j;
				}
				break;
			case DOWN:
				for(int j = 0; j < shipHP; j++){
					shipCoordinates[0][j] = startPointX;
					shipCoordinates[1][j] = startPointY + j;
				}
				break;
			case RIGHT:
				for(int j = 0; j < shipHP; j++){
					shipCoordinates[0][j] = startPointX + j;
					shipCoordinates[1][j] = startPointY;
				}
				break;
			case LEFT:
				for(int j = 0; j < shipHP; j++){
					shipCoordinates[0][j] = startPointX - j;
					shipCoordinates[1][j] = startPointY;
				}
			}
			
			// init ShipComponent	
        }
    }

	/**
	* this method returns which direction a ship 
	* should direct
	*
	*
	*/
    private Direction directShip(int x, int y, int shipHP){
        int topLeftEdge = (shipHP -1);
        int bottomEdge = (this.fieldLength - topLeftEdge);
        int rightEdge = (this.fieldWidth - topLeftEdge);
        Direction[] availableDirection = {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
		int randomNum = (int)Math.floor(Math.random() * 4);

        if(y <= topLeftEdge){
            availableDirection[0] = Direction.DOWN;
        }
		else if(y >= bottomEdge){
			availableDirection[1] = Direction.UP;
		}
		if(x <= topLeftEdge){
			availableDirection[2] = Direction.RIGHT;
		}
		else if (x >= rightEdge){
			availableDirection[3] = Direction.LEFT;
		}
		
		return availableDirection[randomNum];
		
    }
	
	// TODO whats the hell am I doing here? coefficient? why would I need it?
	private void initShip(int x, int y, int coefficientX, int coefficientY, int shipHP){
		int coordinateX;
		int coordinateY;
		for(int j = 0; j < shipHP; j++){
			coordinateX = x + (j * coefficientX);
			coordinateY = x + (j * coefficientY);
			//this.shipLocation[coordinateX][coordinateY] = 
		}
	}
}

class Player {
    int numTrial;

	public void setNumTrial(int numTrial){
		this.numTrial = numTrial;
	}
	public int getNumTrial(){
		return this.numTrial;
	}

    void shoot() {
        int x;
        int y;
        String input = "";
        String[] splitInput = new String[2];
		char[] charArray = {'A','B','C','D','E','F','G'};
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        boolean invalid = true;

		// get user input until it is a valid one
        Scanner in = new Scanner(System.in);
		do {
			System.out.println("Enter coordinate");
			input = in.next();
			
			String pattern = "[a-gA-G][1-7]";
			String msg = "Coordinate must be the combination of A to G and 1 to 7.";
            // input validation
            if (input.length() != 2) {
                System.err.println(msg);
            }
            else if (!input.matches(pattern)){
                System.err.println(msg);
            }
            else {
                invalid = false;
            }
        }while(invalid);
		in.close();
		
        splitInput = input.split("|");
        
		// initiate a map to convert letter to number
		for (int i = 0; i < charArray.length; i++){
			map.put(charArray[i], i);
		}
		
		// get coordinate X
		x = map.get(splitInput[1].toUpperCase());
		
		//get coordinate Y
        y = Integer.parseInt(splitInput[2]);
        
    }
}
