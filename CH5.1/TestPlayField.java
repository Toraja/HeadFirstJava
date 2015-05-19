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
isPlaceable
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
		
		testGetRandomLocNum();

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

	}

	private static void testCheckShipOnTheWay(){

	}

	private static void testPlaceShipComponents(){

	}
 }
