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
 
 public class TestPlayField{
 
	static Class<?> testClass = PlayField.class;
	static String testFailedMsg = "Case %s failed. %s\n";
 
	public static void main(String[] args){
		System.out.println("### Start TestPlayField ###");
		
//		testGetRandomLocNum();
		testCheckOnTheEdge();

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

			int[] testInput1 = {1, 8, 57, 64}; // every corner 
			Direction[] UR = {Direction.Up, Direction.Right};
			Direction[] UL = {Direction.Up, Direction.Left};
			Direction[] DR = {Direction.Down, Direction.Right};
			Direction[] DL = {Direction.Down, Direction.Left};
			Direction[][] expectedValue1 = {DR, DL, UR, UL};
			boolean testSucceeded = true;

			// test for each corner for each size
			for(int i = 0; i < ShipSize.values().length; i++){
				for(int j = 0; j < testInput1.length; j++){
					ArrayList<Direction> actualResult = testMethod.invoke(playField, testInput[j], ShipSize.values()[i]);
					if(! Arrays.equals(expectedValue1[j], actualResult.toArray()){
						System.out.format(testFailedMsg, "corner " + ShipSize.values()[i] + " " + j, "");
						testSucceeded = false;
					}
				}
			}
			if(testSucceeded){
				System.out.println("test for corner succeeded");
			}

			// test for upper edge
			testSucceeded = true;

		System.out.println("### End testCheckOnTheEdge ###");
	}

	private static void testCheckShipOnTheWay(){

	}

	private static void testPlaceShipComponents(){

	}
 }
