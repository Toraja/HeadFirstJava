import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class SinkADotCom {
    public static void main(String[] args){
    // TODO add code here
    }
}

class Ship{
    private String name;
    private int shipHP;
	private static int shipSize = 3;
    
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
	
	public void setShipSize(int shipSize){
		this.shipSize = shipSize;
	}
	public int getShipSize(){
		return this.shipSize;
	}

}

class ShipComponent {
    Ship parentShip;
    
    

	public void setParentShip(Ship parentShip){
			this.parentShip = parentShip;
	}
	public Ship getParentShip(){
			return this.parentShip;
	}
}

class Field {
    private int shipNum;
	private final int FIELD_LENGTH = 7;
	private final int FIELD_WIDTH = 7;
    private ShipComponent[][] shipLocation = new ShipComponent[FIELD_LENGTH][FIELD_WIDTH];
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int RIGHT = 3;
    private static final int LEFT = 4;
    private enum Direction {UP, DOWN, RIGHT, LEFT};
    
	public Field(int shipNum){
		this.shipNum = shipNum;
	}

    public void setShipNum(int num){
        this.shipNum = num;
    }
    public int getShipNum(){
        return this.shipNum;
    }
    
	public void setShipLocation(ShipComponent shipLocation, int x, int y){
        this.shipLocation[x][y] = shipLocation;
	}
	public ShipComponent getShipLocation(int x, int y){
		return this.shipLocation[x][y];
	}
	
	// TODO create method initField()
    public void initField(int shipNum){
        int startPointX;
        int startPointY;
		int[][] shipCoodinates = new int[2][this.shipSize]; // first row: x, second row: y
	
        setShipNum(shipNum);
		
        // create 3 sets of ship component
        for (int i = 0; i < shipNum; i++){
            // generate 3 pair of random number
            startPointX = (int)Math.floor(Math.random()*FIELD_WIDTH);
            startPointY = (int)Math.floor(Math.random()*FIELD_LENGTH);
				
			switch(directShip(startPointX, startPointY)){
			case Drection.UP:
				for(int j = 0; j < this.shipSize; j++){
					shipCoordinates[0][j] = startPointX;
					shipCoordinates[1][j] = startPointY - j;
				}
				break;
			case Drection.DOWN:
				for(int j = 0; j < this.shipSize; j++){
					shipCoordinates[0][j] = startPointX;
					shipCoordinates[1][j] = startPointY + j;
				}
				break;
			case Drection.RIGHT:
				for(int j = 0; j < this.shipSize; j++){
					shipCoordinates[0][j] = startPointX + j;
					shipCoordinates[1][j] = startPointY;
				}
				break;
			case Drection.LEFT:
				for(int j = 0; j < this.shipSize; j++){
					shipCoordinates[0][j] = startPointX - j;
					shipCoordinates[1][j] = startPointY;
				}
			}
			
				
        }
    }

    private Direction directShip(int x, int y){
        int topLeftEdge = (this.shipSize -1);
        int bottomEdge = (this.FIELD_LENGTH - topLeftEdge);
        int rightEdge = (this.FIELD_WIDTH - topLeftEdge);
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
	
	private void initShip(int x, int y, int coefficientX, int coefficientY){
		for(int j = 0; j < this.shipSize; j++){
			coordinateX = x + (j * coefficientX)
			coordinateY = x + (j * coefficientY)
			this.shipLocation[coordinateX][coordinateY] = 
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
