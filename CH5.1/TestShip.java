//					test drive	result
//getHpOfSize		ok			ok
//Ship				n/a			n/a
//getName			n/a			n/a
//getHp				n/a			n/a
//getSize			n/a			n/a
//initShips			ok			ok
//getRandomShipName	ok			ok

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Method;
//import Ship;

public class TestShip{

	static Class<?> testClass = Ship.class;
	static String testFailedMsg = "Case %s failed. %s\n";
	
	public static void main(String[] args) {
//		testGetRandomShipName();
//		testGetHpOfSize();
		testInitShips();
	}
	
	private static void testGetRandomShipName(){
		System.out.println("### Start testGetRandomShipName ###");
		
		
		ArrayList<String> shipNameList = new ArrayList<String>(Arrays.asList("Google.com", "facebood.com", "Apple.com", "Microsoft.com", "Wikipedia.com", "YouTube.com", "Twitter.com", "Kickstarter.com", "Evernote.com"));

		try {
			Method testMethod = testClass.getDeclaredMethod("getRandomShipName", ArrayList.class);
			testMethod.setAccessible(true);
			for(int i = 0; i < 3; i++){
				String shipName = (String)testMethod.invoke(testClass, shipNameList);
				System.out.println(shipName);
				System.out.println(Arrays.toString(shipNameList.toArray()));
				if (shipNameList.contains(shipName)) { // 
					System.out.format(testFailedMsg, i+1, "");
				}
			}
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}

		System.out.println("### End testGetRandomShipName ###");
	}
	
	private static void testGetHpOfSize(){
		try {
			Class<?> shipSize = Ship.ShipSize.class;
			Method testMethod = shipSize.getDeclaredMethod("getHpOfSize");
			testMethod.setAccessible(true);
			
			System.out.println(testMethod.invoke(Ship.ShipSize.Large));
			System.out.println(testMethod.invoke(Ship.ShipSize.Mid));
			System.out.println(testMethod.invoke(Ship.ShipSize.Small));
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	private static void testInitShips(){
		System.out.println("### Start testInitShips ###");
		
		int[] input = {5, 7, 9};
		ArrayList<Ship> shipList;
				
		for(int i = 0; i < input.length; i++){
			int largeShipNum = 0;		
			int midShipNum = 0;		
			int smallShipNum = 0;
			
			shipList = Ship.initShips(input[i]);
			
			System.out.println("total number of ship: " + shipList.size());
			
			for(Ship ship : shipList){
				switch(ship.getSize()){
					case Large: 
						largeShipNum++;
						break;
					case Mid: 
						midShipNum++; 
						break;
					case Small: 
						smallShipNum++; 
						break;
				}
			}
			
			System.out.println("the number of large ship: " + largeShipNum);
			System.out.println("the number of mid ship: " + midShipNum);
			System.out.println("the number of small ship: " + smallShipNum);
			System.out.println();
		}
		
		System.out.println("### End testInitShips ###");
	}
}
