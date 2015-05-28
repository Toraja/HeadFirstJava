/*					test drive	result 
PlayField
getShipNum			n/a
getFieldLength		n/a
getFieldWidth		n/a
getShipOnLocNum		n/a
placeShips
removeShip			n/a
decrementShipNum	n/a
getRandomLocNum		ok
isPlaceable			n/a
directShip
checkOnTheEdge		
checkShipOnTheWay
buildShip	
 */

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.ArrayList;

 public class TestPlayField{
 
	static Class<?> testClass = PlayField.class;
	static String testFailedMsg = "Case %s failed. %s\n";
 
	public static void main(String[] args){
		System.out.println("### Start TestPlayField ###");
		
//		testGetRandomLocNum();
		testCheckOnTheEdge();
		System.out.println(Arrays.toString(generateTestLocNum(8, 8, 3, true, false)));

		System.out.println("### End TestPlayField ###");
	}
 
	private static void testPlayField(){

	}

	private static void testGetShipOnCoordinate(){

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

	private static void testIsPlaceable(){

	}

	private static void testDirectShip(){

	}

	private static void testCheckOnTheEdge(){
		System.out.println("### Start testCheckOnTheEdge ###");
		
		
		try{
			StubPlayField spf = new StubPlayField();
			spf.setFieldLengthAndWidth(8, 8);
			PlayField playField = spf;
			
			Method testMethod = testClass.getDeclaredMethod("checkOnTheEdge");
			testMethod.setAccessible(true);

			PlayField.Direction[] UR = {PlayField.PlayField.Direction.Up, PlayField.PlayField.Direction.Right};
			PlayField.Direction[] UL = {PlayField.Direction.Up, PlayField.Direction.Left};
			PlayField.Direction[] DR = {PlayField.Direction.Down, PlayField.Direction.Right};
			PlayField.Direction[] DL = {PlayField.Direction.Down, PlayField.Direction.Left};
			PlayField.Direction[][] expectedValue1 = {DR, DL, UR, UL};
			boolean testSucceeded = true;

			// test for each corner for each size (non-limited)
			for(int i = 0; i < Ship.ShipSize.values().length; i++){
				int[] testInput = generateTestLocNum(8, 8, Ship.ShipSize.values()[i], true, false);
				for(int j = 0; j < testInput.length; j++){
					ArrayList<PlayField.Direction> actualResult = (ArrayList<PlayField.Direction>)testMethod.invoke(playField, testInput[j], Ship.ShipSize.values()[i]);
					if(! Arrays.equals(expectedValue1[j], actualResult.toArray())){
						System.out.format(testFailedMsg, "corner " + Ship.ShipSize.values()[i] + " " + j, "");
						testSucceeded = false;
					}
				}
			}
			if(testSucceeded){
				System.out.println("test for corner succeeded");
			}

			// test for the each edge (non-limited)
			testSucceeded = true;
			for(int i = 0; i < Ship.ShipSize.values().length; i++){
				int[] testInput = generateTestLocNum(8, 8, Ship.ShipSize.values()[i].getHpOfSize(), false, false);
				for(int j = 0; j < testInput.length; j++){
					// TODO implement
				}
			}
		}catch(Exception e){
			// TODO implement
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

	private static void testPlaceShipComponents(){

	}
 }
