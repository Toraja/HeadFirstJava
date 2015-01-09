import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SinkADotCom {
    public static void main(String[] args){
		// TODO add code here
	
		// construct Field with num of ships and the size of field
		try{
			Field field = new Field(3, 7, 7);
		}
		catch(Exception e){
			System.err.println("Program halted");
		}
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
		this.shipHP = ShipInfo.getShipHPForType(shipSizeType);
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
	
	public void setShipSizeType(ShipInfo.ShipSize shipSizeType){
		this.shipSizeType = shipSizeType;
	}
	public ShipInfo.ShipSize getShipSizeType(){
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
	
	public static int getShipNamesLength(){
		return shipNames.length;
	}
	public static void setShipNames(String shipName, int index){
		shipNames[index] = shipName;
	}
	public static String getShipNames(int index){
		return shipNames[index];
	}
	
	public static int getShipNamesAssignedLength(){
		return shipNamesAssigned.length;
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
	
	public static String getRandomShipNames() throws Exception{
		int count = 0;
		int index;
		String shipName = "";
		
		do{
			index = (int)Math.floor(Math.random()*shipNames.length);
			if(!shipNamesAssigned[index]){
				shipName = shipNames[index];
				shipNamesAssigned[index] = true;
				break;
			}
			
			while(shipNamesAssigned[count]){
				count++;
				if(count == shipNamesAssigned.length){
					System.err.println("All the names have been assigned. Unable to continue.");
					throw new Exception();
				}
			}
		}while(true);
		
		return shipName;
	}
	
	public static int getShipHPForType(ShipSize shipSize){
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
	
	public static void resetNameAssignment(){
		for(int i = 0; i < shipNamesAssigned.length; i++){
			shipNamesAssigned[i] = false;
		}
	}
}

class Field {
    private int shipNum;
	private int fieldLength;
	private int fieldWidth;
	private Ship[] ships;
    private ShipComponent[][] shipLocation = new ShipComponent[fieldLength][fieldWidth];
    private static final int NOWHERE = 0;
	private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int RIGHT = 3;
    private static final int LEFT = 4;
    private enum Direction {NOWHERE, UP, DOWN, RIGHT, LEFT};
    
	// init variables as well as parents ship
	public Field(int shipNum, int fieldLength, int fieldWidth) throws Exception{
		this.shipNum = shipNum;
		this.fieldLength = fieldLength;
		this.fieldWidth = fieldWidth;
		
		// initiate an array for parentShips
		this.ships = new Ship[shipNum];
		// put ships in the array
		for(int i = 0; i < this.shipNum; i++){
			// initiate ships
			this.ships[i] = new Ship(ShipInfo.getRandomShipNames(), ShipInfo.ShipSize.MID);
		}
	}

    public void setShipNum(int num){
        this.shipNum = num;
    }
    public int getShipNum(){
        return this.shipNum;
    }
    
    public void setShips(Ship ships, int index){
		this.ships[index] = ships;
	}
	public Ship getShips(int index){
		return this.ships[index];
	}
    
	public void setShipLocation(ShipComponent shipComponent, int x, int y){
        this.shipLocation[x][y] = shipComponent;
	}
	public ShipComponent getShipLocation(int x, int y){
		return this.shipLocation[x][y];
	}
	
	    public void initField(){
        int startPointX;
        int startPointY;
		int shipHP;
		boolean built = false; // whether a ship has been successfully built
		// int[][] shipCoordinates; // first row: x, second row: y
	
        // create 3 sets of ship component
        for (int i = 0; i < this.shipNum; i++){
			shipHP = this.ships[i].getShipHP();
			// shipCoordinates = new int[2][shipHP];
			while(!built){
				// generate a pair of random number
				startPointX = (int)Math.floor(Math.random()*fieldWidth);
				startPointY = (int)Math.floor(Math.random()*fieldLength);
				// convert built to true in advance. change it back to false if it fails
				built = true;	
				switch(directShip(startPointX, startPointY, shipHP)){
				case UP:
					for(int j = 0; j < shipHP; j++){
						shipLocation[startPointX][startPointY - j] = new ShipComponent(this.ships[i]);
					}
					break;
				case DOWN:
					for(int j = 0; j < shipHP; j++){
						shipLocation[startPointX][startPointY + j] = new ShipComponent(this.ships[i]);
					}
					break;
				case RIGHT:
					for(int j = 0; j < shipHP; j++){
						shipLocation[startPointX + j][startPointY] = new ShipComponent(this.ships[i]);
					}
					break;
				case LEFT:
					for(int j = 0; j < shipHP; j++){
						shipLocation[startPointX - j][startPointY] = new ShipComponent(this.ships[i]);
					}
					break;
				case NOWHERE:
					built = false;
				}
			}
        }
    }

	/**
	* This method returns which direction a ship can head
	* This also avoids collision
	*
	*/
    private Direction directShip(int x, int y, int shipHP){
        int topEdge = (shipHP -2);
        int leftEdge = (shipHP -2);
        int bottomEdge = (this.fieldLength - 1 - topEdge);
        int rightEdge = (this.fieldWidth - 1 - leftEdge);
        Direction shipDirection = Direction.NOWHERE;
        // Direction[] availableDirection = {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
		ArrayList<Direction> directionList = new ArrayList<Direction>();
		boolean upAvailable = true;
		boolean downAvailable = true;
		boolean rightAvailable = true;
		boolean leftAvailable = true;
		int randomNum; // = (int)Math.floor(Math.random() * 4);

		// change the availability of each direction depending on the ship's initializing coordinate
        if(y <= topEdge){
            upAvailable = false;
			// availableDirection[0] = Direction.DOWN;
        }
		else if(y >= bottomEdge){
			downAvailable = false;
			// availableDirection[1] = Direction.UP;
		}
		if(x <= leftEdge){
			leftAvailable = false;
			// availableDirection[2] = Direction.RIGHT;
		}
		else if (x >= rightEdge){
			rightAvailable = false;
			// availableDirection[3] = Direction.LEFT;
		}
		
		// see if other ships are on the way
		if(upAvailable){
			for(int i = 1; i < shipHP; i++){
				if(shipLocation[x][y-i] != null){
					upAvailable = false;
					break;
				}
			}
		}
		if(downAvailable){
			for(int i = 1; i < shipHP; i++){
				if(shipLocation[x][y+i] != null){
					downAvailable = false;
					break;
				}
			}
		}
		if(leftAvailable){
			for(int i = 1; i < shipHP; i++){
				if(shipLocation[x-i][y] != null){
					leftAvailable = false;
					break;
				}
			}
		}
		if(rightAvailable){
			for(int i = 1; i < shipHP; i++){
				if(shipLocation[x+i][y] != null){
					rightAvailable = false;
					break;
				}
			}
		}
		if(upAvailable){
			directionList.add(Direction.UP);
		}
		if(downAvailable){
			directionList.add(Direction.DOWN);
		}
		if(rightAvailable){
			directionList.add(Direction.RIGHT);
		}
		if(leftAvailable){
			directionList.add(Direction.LEFT);
		}
		
		if(directionList.size() != 0){
			randomNum = (int)Math.floor(Math.random() * directionList.size());
			shipDirection = directionList.get(randomNum);
		}
		else{
			shipDirection = Direction.NOWHERE;
		}
		
		return shipDirection;
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
                System.out.println(msg);
            }
            else if (!input.matches(pattern)){
                System.out.println(msg);
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
