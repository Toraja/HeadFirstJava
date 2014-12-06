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
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
//    public void setId(int id){
//        this.id = id;
//    }
//    public int getId(){
//        return this.id;
//    }
    public void setShipHP(int shipHP){
        this.shipHP = shipHP;
    }
    public int getShipHP(){
        return this.shipHP;
    }
}

class Field {
    int shipNum;
    private ShipComponent[][] shipLocation = new ShipComponent[7][7];
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int RIGHT = 3;
    private static final int LEFT = 4;
    private enum Direction {UP, DOWN, RIGHT, LEFT};
    
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
        int random1;
        int random2;
    
        this.shipNum = shipNum;
        // create 3 sets of ship component
        for (int i = 0; i < shipNum; i++){
            // generate 3 pair of random number
            random1 = (int)Math.floor(Math.random()*7);
            random2 = (int)Math.floor(Math.random()*7);
        
        }
    }

    private Direction directShip(int x, int y){
        final int FIELD_LENGTH = 7;
        final int FIELD_WIDTH = 7;
        final int SHIP_SIZE = 3;
        int topLeftEdge = (SHIP_SIZE -1);
        int bottomEdge = (FIELD_LENGTH - topLeftEdge);
        int rightEdge = (FIELD_WIDTH - topLeftEdge);
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
    
//    public void setShipHP(int shipHP, int idx){
//        this.shipHP[idx] = shipHP;
//    }
//    public int getShipHP(int idx){
//        return this.shipHP[idx];
//    }
}

class ShipComponent {
    Ship parentShip = new Ship();

	public void setParentShip(Ship parentShip){
			this.parentShip = parentShip;
	}
	public Ship getParentShip(){
			return this.parentShip;
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
