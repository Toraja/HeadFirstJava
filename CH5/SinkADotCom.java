import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SinkADotCom {
    public static void main(String[] args){

		playGame(25);
		
    }
    
    static void playGame(int maxTrial){
		// construct Field with num of ships and the size of field
		try{
			Field field = new Field(3, 7, 7);
			field.placeShips();
			
			Player player = new Player();
			
			Scanner in = new Scanner(System.in);
			while(field.getShipNum() > 0){
				player.shoot(field, in);
			}
			in.close();
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
    private ShipComponent[][] shipLocation;
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
		this.shipLocation = new ShipComponent[fieldLength][fieldWidth];
		
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

	public void setFieldLength(int fieldLength){
		this.fieldLength = fieldLength;
	}
	public int getFieldLength(){
		return this.fieldLength;
	}

	public void setFieldWidth(int fieldWidth){
		this.fieldWidth = fieldWidth;
	}
	public int getFieldWidth(){
		return this.fieldWidth;
	}

    public void setShips(Ship ships, int index){
		this.ships[index] = ships;
	}
	public Ship getShips(int index){
		return this.ships[index];
	}
    
	public void setShipLocation(ShipComponent shipComponent, int y, int x){
        this.shipLocation[y][x] = shipComponent;
	}
	public ShipComponent getShipLocation(int y, int x){
		return this.shipLocation[y][x];
	}
	public int getShipLocationWidth(){
		return this.shipLocation.length;
	}
	public int getShipLocationLength(){
		int length = 0;
		
		if(this.shipLocation.length > 0){
			length = this.shipLocation[0].length;
		}
		
		return length;
	}
	
	public void placeShips(){
        int startPointX = 0;
        int startPointY = 0;
		int shipHP;
		boolean collided = false; // whether a ship already exists at stating point 
		boolean built = false; // whether a ship has been successfully built
		// int[][] shipCoordinates; // first row: x, second row: y
	
        // create 3 sets of ship component
        for (int i = 0; i < this.shipNum; i++){
			shipHP = this.ships[i].getShipHP();
			// shipCoordinates = new int[2][shipHP];
			while(!built){
				collided = true;
				while(collided){
					// generate a pair of random number
					startPointX = (int)Math.floor(Math.random()*fieldWidth);
					startPointY = (int)Math.floor(Math.random()*fieldLength);
					if(this.getShipLocation(startPointY,startPointX) == null){
						collided = false;
					}
				}
				// convert built to true in advance. change it back to false if it fails
				built = true;	
				switch(directShip(startPointY, startPointX, shipHP)){
				case UP:
					for(int j = 0; j < shipHP; j++){
						shipLocation[startPointY - j][startPointX] = new ShipComponent(this.ships[i]);
						//for debug
						//printShips((startPointY - j),(startPointX),"UP",shipLocation[startPointY - j][startPointX]);
					}
					break;
				case DOWN:
					for(int j = 0; j < shipHP; j++){
						shipLocation[startPointY + j][startPointX] = new ShipComponent(this.ships[i]);
						//for debug
						//printShips((startPointY + j),(startPointX),"DOWN",shipLocation[startPointY + j][startPointX]);
					}
					break;
				case RIGHT:
					for(int j = 0; j < shipHP; j++){
						shipLocation[startPointY][startPointX + j] = new ShipComponent(this.ships[i]);
						//for debug
						//printShips((startPointY),(startPointX + j),"RIGHT",shipLocation[startPointY][startPointX + j]);
					}
					break;
				case LEFT:
					for(int j = 0; j < shipHP; j++){
						shipLocation[startPointY][startPointX - j] = new ShipComponent(this.ships[i]);
						//for debug
						//printShips((startPointY),(startPointX - j),"LEFT",shipLocation[startPointY][startPointX - j]);
					}
					break;
				case NOWHERE:
					built = false;
				}
			}
			built = false;
        }
    }

	/**
	* This method returns which direction a ship can head
	* This also avoids collision
	*
	*/
    private Direction directShip(int y, int x, int shipHP){
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
				if(shipLocation[y-i][x] != null){
					upAvailable = false;
					break;
				}
			}
		}
		if(downAvailable){
			for(int i = 1; i < shipHP; i++){
				if(shipLocation[y+i][x] != null){
					downAvailable = false;
					break;
				}
			}
		}
		if(leftAvailable){
			for(int i = 1; i < shipHP; i++){
				if(shipLocation[y][x-i] != null){
					leftAvailable = false;
					break;
				}
			}
		}
		if(rightAvailable){
			for(int i = 1; i < shipHP; i++){
				if(shipLocation[y][x+i] != null){
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
    
    /**
    * For debugging placeShips method
    */
    private static void printShips(int y, int x, String direction, ShipComponent shipComp){
    	System.out.println(direction + " " + y + " " + x + " " + shipComp.getParentShip().getName());
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

    void shoot(Field field, Scanner in) {
        int x;
        int y;
        ShipComponent shipComponent;
        Ship parentShip;
        String input = "";
        String[] splitInput;
		String[] charArray = {"A","B","C","D","E","F","G"};
		Map<String, Integer> map = new HashMap<String, Integer>();
        boolean invalid = true;

		// get user input until it is a valid one
		do {
			System.out.println("Enter coordinate");
			input = in.next();

			String pattern = "[a-gA-G][1-7]";
			String msg = "Coordinate must be the combination of A to G and 1 to 7.";
	        // input validation
	        if (!(input.length() == 2 && input.matches(pattern))){
	            System.out.println(msg);
	        }
	        else {
	            invalid = false;
	        }
	    }while(invalid);

        splitInput = input.split("|");

		// initiate a map to convert letter to number
		for (int i = 0; i < charArray.length; i++){
			map.put(charArray[i], i);
		}

        this.numTrial++;

		// get coordinate X
		x = map.get(splitInput[1].toUpperCase());

		//get coordinate Y

        y = Integer.parseInt(splitInput[2]) - 1;

        shipComponent = field.getShipLocation(y, x);
        if(shipComponent == null){
        	System.out.println("Miss");
        }
        else{
        	parentShip = shipComponent.getParentShip();
        	System.out.println("Hit " + parentShip.getName() + " !");
        	
        	field.setShipLocation(null, y, x);
        	
        	parentShip.setShipHP(parentShip.getShipHP() - 1);
        	
        	if(parentShip.getShipHP() == 0){
        		System.out.println("Sinked " + parentShip.getName() + " !!");
        		field.setShipNum(field.getShipNum() - 1);
        			if(field.getShipNum() == 0){
        				System.out.println("Congrats!! You have sunk all the DotComs in " + this.numTrial + " shots!");
        			}
        	}
        }
    }
}
