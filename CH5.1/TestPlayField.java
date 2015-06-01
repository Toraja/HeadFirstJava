/*					test drive	result 
PlayField
getShipNum			n/a			n/a
getFieldLength		n/a			n/a
getFieldWidth		n/a			n/a
getShipOnLocNum		n/a			n/a
placeShips
removeShip			n/a			n/a
decrementShipNum	n/a			n/a
getRandomLocNum		ok			ok
isPlaceable			n/a			n/a
directShip
checkOnTheEdge		ok			ok
checkShipOnTheWay
buildShip			ok			ok
getIncIdx			ok			ok
 */

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

 public class TestPlayField{
 
	static Class<?> testClass = PlayField.class;
	static String testFailedMsg = "Case %s failed. %s\n";
 
	public static void main(String[] args){
		System.out.println("### Start TestPlayField ###");
		
//		testGetRandomLocNum();
		// testCheckOnTheEdge();
		testBuildShip();

		System.out.println("### End TestPlayField ###");
	}
 
	private static void testPlayField(){

	}

	private static void testPlaceShips(){

	}
	
	private static void testGetRandomLocNum(){
		System.out.println("### Start testGetRandomLocNum ###");
		
		try{
			StubPlayField spf = new StubPlayField();
			spf.setFieldLengthAndWidth(8, 7);
			PlayField playField = spf;
			
			Method testMethod = testClass.getDeclaredMethod("getRandomLocNum");
			testMethod.setAccessible(true);
			int locNum = 0;

			for(int i = 0; i < 5; i++){
				locNum = (int)testMethod.invoke(playField);
				
				if (!(1 <= locNum && locNum <= 56)) { // 
					System.out.printf(testFailedMsg, "1-" + (i + 1), " locNum: " + locNum);
				}
			}
			
			spf.setFieldLengthAndWidth(15, 9);
			playField = spf;
			
			for(int i = 0; i < 5; i++){
				locNum = (int)testMethod.invoke(playField);
				
				if (!(1 <= locNum && locNum <= 135)) { // 
					System.out.printf(testFailedMsg, "2-" + (i + 1), " locNum: " + locNum);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("### End testGetRandomLocNum ###");
	}

	private static void testDirectShip(){

	}

	private static void testCheckOnTheEdge(){
		System.out.println("### Start testCheckOnTheEdge ###");
		
	
		try{
			StubPlayField spf = new StubPlayField();
			spf.setFieldLengthAndWidth(8, 8);
			PlayField playField = spf;
			
			Method testMethod = testClass.getDeclaredMethod("checkOnTheEdge", int.class, Ship.ShipSize.class);
			testMethod.setAccessible(true);
			int[] testInput;

			// corner
			for(int i = 0; i < Ship.ShipSize.values().length; i++){
				System.out.println("Ship size: " + Ship.ShipSize.values()[i]);
				// case 1
				System.out.println("Test case: 8 x 8 * corner * non-limited");
				testInput = generateTestLocNum(8, 8, Ship.ShipSize.values()[i].getHpOfSize(), true, false);
				for(int j = 0; j < testInput.length; j++){
					System.out.print("LocNum: " + testInput[j] + " - Directions: ");
					System.out.println(Arrays.toString(((ArrayList<?>)testMethod.invoke(playField, testInput[j], Ship.ShipSize.values()[i])).toArray()));
				}

				// case 2
				System.out.println("Test case: 8 x 8 * corner * limited");
				testInput = generateTestLocNum(8, 8, Ship.ShipSize.values()[i].getHpOfSize(), true, true);
				for(int j = 0; j < testInput.length; j++){
					System.out.print("LocNum: " + testInput[j] + " - Directions: ");
					System.out.println(Arrays.toString(((ArrayList<?>)testMethod.invoke(playField, testInput[j], Ship.ShipSize.values()[i])).toArray()));
				}
			}

			// edge
			for(int i = 0; i < Ship.ShipSize.values().length; i++){
				System.out.println("Ship size: " + Ship.ShipSize.values()[i]);
				// case 3
				System.out.println("Test case: 8 x 8 * edge * non-limited");
				testInput = generateTestLocNum(8, 8, Ship.ShipSize.values()[i].getHpOfSize(), false, false);
				for(int j = 0; j < testInput.length; j++){
					System.out.print("LocNum: " + testInput[j] + " - Directions: ");
					System.out.println(Arrays.toString(((ArrayList<?>)testMethod.invoke(playField, testInput[j], Ship.ShipSize.values()[i])).toArray()));
				}

				// case 4
				System.out.println("Test case: 8 x 8 * edge * limited");
				testInput = generateTestLocNum(8, 8, Ship.ShipSize.values()[i].getHpOfSize(), false, true);
				for(int j = 0; j < testInput.length; j++){
					System.out.print("LocNum: " + testInput[j] + " - Directions: ");
					System.out.println(Arrays.toString(((ArrayList<?>)testMethod.invoke(playField, testInput[j], Ship.ShipSize.values()[i])).toArray()));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("### End testCheckOnTheEdge ###");
	}

	private static int[] generateTestLocNum(int fieldLength, int fieldWidth, int sizeValue, boolean isCorner, boolean limited){
		
		int adjuster = 0;
		if(limited){
			sizeValue = sizeValue - 1;
		}

		int[] testInput = new int[4];
		if(isCorner){
			testInput[0] = fieldWidth * (sizeValue - 1) + sizeValue; // upper left corner
			testInput[1] = fieldWidth * sizeValue - (sizeValue - 1); // upper right corner
			testInput[2] = fieldWidth * (fieldLength - sizeValue) + sizeValue; // bottom left corner
			testInput[3] = fieldWidth * (fieldLength - (sizeValue - 1)) - (sizeValue - 1); // bottom right corner
		}
		else{
			testInput[0] = fieldWidth * (sizeValue - 1) + (fieldWidth / 2); // upper edge
			testInput[1] = fieldWidth * (int)(fieldLength / 2) + sizeValue; // left edge
			testInput[2] = fieldWidth * (int)(fieldLength / 2) - (sizeValue - 1); // right edge
			testInput[3] = fieldWidth * (fieldLength - sizeValue) + (int)(fieldWidth / 2); // bottom edge
		}

		return testInput;
	}

	private static void testCheckShipOnTheWay(){

	}

	private static void testBuildShip(){
			System.out.println("### Start testBuildShip ###");

			StubPlayField spf = new StubPlayField();
			spf.setFieldLengthAndWidth(8, 8);
			PlayField playField = spf;
			
			try{
				Method testMethod = testClass.getDeclaredMethod("buildShip", Ship.class, int.class, PlayField.Direction.class, Ship.ShipSize.class);
				testMethod.setAccessible(true);
				Field shipLocation = testClass.getDeclaredField("shipLocation");
				shipLocation.setAccessible(true);
				Constructor shipConst = Ship.class.getDeclaredConstructor(Ship.ShipSize.class, ArrayList.class);
				shipConst.setAccessible(true);
				ArrayList<String> shipNameList = new ArrayList<String>();
				shipNameList.add("Google.com");
				Ship ship = null;
				for(Ship.ShipSize shipSize : Ship.ShipSize.values()){ // for each ship size
					ship = (Ship)shipConst.newInstance(shipSize, shipNameList);
					shipNameList.add("Google.com");
					System.out.println("Current ship size: " + shipSize);
 					for(PlayField.Direction direction : PlayField.Direction.values()){ // test each direction
						System.out.println("Current direction: " + direction);
						testMethod.invoke(playField, ship, 28, direction, shipSize);
						System.out.println(((Map)(shipLocation.get(playField))).entrySet());
						shipLocation.set(playField, new HashMap<Integer, Ship>());
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println("### End testBuildShip ###");
	}
 }
