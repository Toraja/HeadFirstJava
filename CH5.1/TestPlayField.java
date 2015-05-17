/*					test drive	result 
PlayField
getShipNum			n/a
getFieldLength		n/a
getFieldWidth		n/a
getShipOnLocNum		n/a
placeShips
removeShip			n/a
decrementShipNum	n/a
getRandomLocNum
isPlacable
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
		testGetRandomLocNum();
	}
 
	private static void testPlayField(){

	}

	private static void testGetShipOnCoordinate(){

	}

	private static void testPlaceShips(){

	}
	
	private static void testGetRandomLocNum(){
		try{
			Field fieldLength = testClass.getDeclaredField("fieldLength");
			Field fieldWidth = testClass.getDeclaredField("fieldWidth");
			fieldLength.setAccessible(true);
			fieldWidth.setAccessible(true);
			
			// needs to initialize field object... stub?
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void testIsPlacable(){

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