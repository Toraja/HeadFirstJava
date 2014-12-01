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

class Field { // TODO 1 field for 1 game. Game and Field can be combined?
    int shipNum;
    private ShipComponent[][] field = new ShipComponent[7][7];
//    int[] shipHP;
    
    public void setShipNum(int num){
        this.shipNum = num;
    }
    public int getShipNum(){
        return this.shipNum;
    }
    
	public void setField(ShipComponent field, int x, int y){
        this.field[x][y] = field;
	}
	public ShipComponent getField(int x, int y){
		return this.field[x][y];
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
	
	// am I in work repo?
}
