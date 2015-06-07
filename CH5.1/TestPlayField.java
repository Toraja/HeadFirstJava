/*					test drive	result 
PlayField			n/a			n/a
getShipNum			n/a			n/a
getFieldLength		n/a			n/a
getFieldWidth		n/a			n/a
getShipOnLocNum		n/a			n/a
placeShips			
removeShip			n/a			n/a
decrementShipNum	n/a			n/a
getRandomLocNum		ok			ok
isPlaceable			n/a			n/a
directShip			ok			ok
checkOnTheEdge		ok			ok
checkShipOnTheWay	ok			ok
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
		
		//testGetRandomLocNum();
		// testCheckOnTheEdge();
		//testBuildShip();
		//testCheckShipOnTheWay();
		testDirectShip();

		System.out.println("### End TestPlayField ###");
	}
 
	private static void testPlayField(){

	}

	private static void testPlaceShips(){
		System.out.println("### Start testPlaceShip ###");
		
		try{
			int fieldLength = 9;
			int fieldWidth = 9;
			StubPlayField spf = new StubPlayField();
			spf.setFieldLengthAndWidth(fieldLength, fieldWidth);
			PlayField playField = spf;
			
			Method testMethod = testClass.getDeclaredMethod("placeShips", ArrayList.class);
			testMethod.setAccessible(true);
			Field shipLocation = testClass.getDeclaredField("shipLocation");
			shipLocation.setAccessible(true);
			Method calcTotalShipNum = SinkADotCom.class.getDeclaredMethod("calcTotalShipNum", int.class, int.class);
			ArrayList<Ship> shipList = Ship.initShips((int)calcTotalShipNum.invoke(fieldLength, fieldWidth));

			testMethod.invoke(playField, shipList);

			System.out.println(((Map)(shipLocation.get(playField))).entrySet());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("### End testPlaceShip ###");
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
		System.out.println("### Start testDirectShip ###");

		StubPlayField spf = new StubPlayField();
		spf.setFieldLengthAndWidth(8, 8);
		PlayField playField = spf;
		
		try{
			Method testMethod = testClass.getDeclaredMethod("directShip", int.class, Ship.ShipSize.class);
			testMethod.setAccessible(true);
			Field shipLocation = testClass.getDeclaredField("shipLocation");
			shipLocation.setAccessible(true);
			Constructor<Ship> shipConst = Ship.class.getDeclaredConstructor(Ship.ShipSize.class, ArrayList.class);
			shipConst.setAccessible(true);
			
			ArrayList<String> nameList = new ArrayList<String>();
			nameList.add("test.com");
			Ship ship = shipConst.newInstance(Ship.ShipSize.Mid, nameList);
			int locNum;
			HashMap<Integer, Ship> shipLocMap = new HashMap<Integer, Ship>();
			PlayField.Direction result;
			ArrayList<PlayField.Direction> expected;
			int caseNum = 0;
			boolean succeeded = true;

			// case 1: small ship, upper edge, ship exists below
			caseNum++;
			locNum = 3;
			shipLocMap.put(19, ship);
			shipLocation.set(playField, shipLocMap);
			result = (PlayField.Direction)testMethod.invoke(playField, locNum, Ship.ShipSize.Small);
			expected = new ArrayList<PlayField.Direction>();
			expected.add(PlayField.Direction.Left);
			expected.add(PlayField.Direction.Right);
			if(!expected.contains(result)){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}

			// case 2: mid ship, bottom left corner, ship exists above
			caseNum++;
			locNum = 57;
			shipLocMap.put(49, ship);
			shipLocation.set(playField, shipLocMap);
			result = (PlayField.Direction)testMethod.invoke(playField, locNum, Ship.ShipSize.Mid);
			expected = new ArrayList<PlayField.Direction>();
			expected.add(PlayField.Direction.Right);
			if(!expected.contains(result)){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}
			
			// case 3: large ship, bottom right corner, ship exists on the left
			caseNum++;
			locNum = 54;
			shipLocMap.put(52, ship);
			shipLocation.set(playField, shipLocMap);
			result = (PlayField.Direction)testMethod.invoke(playField, locNum, Ship.ShipSize.Large);
			expected = new ArrayList<PlayField.Direction>();
			expected.add(PlayField.Direction.Up);
			if(!expected.contains(result)){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}

			// case 4: large ship, upper right corner, ship exists below and on the left
			caseNum++;
			locNum = 16;
			shipLocMap.put(14, ship);
			shipLocMap.put(40, ship);
			shipLocation.set(playField, shipLocMap);
			result = (PlayField.Direction)testMethod.invoke(playField, locNum, Ship.ShipSize.Large);
			if(result != null){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}

			if(succeeded){
				System.out.println("testDirectShip succeeded!");
			}

			System.out.println("### End testDirectShip ###");
		}catch(Exception e){
			e.printStackTrace();
		}
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
			testInput[1] = fieldWidth * (fieldLength / 2) + sizeValue; // left edge
			testInput[2] = fieldWidth * (fieldLength / 2) - (sizeValue - 1); // right edge
			testInput[3] = fieldWidth * (fieldLength - sizeValue) + (fieldWidth / 2); // bottom edge
		}

		return testInput;
	}

	private static void testCheckShipOnTheWay(){
		System.out.println("### Start testCheckShipOnTheWay ###");

		StubPlayField spf = new StubPlayField();
		spf.setFieldLengthAndWidth(8, 8);
		PlayField playField = spf;

		try{
			Method testMethod = testClass.getDeclaredMethod("checkShipOnTheWay", int.class,Ship.ShipSize.class, ArrayList.class);
			testMethod.setAccessible(true);
			Field shipLocation = testClass.getDeclaredField("shipLocation");
			shipLocation.setAccessible(true);
			Constructor<Ship> shipConst = Ship.class.getDeclaredConstructor(Ship.ShipSize.class, ArrayList.class);
			shipConst.setAccessible(true);

			ArrayList<String> nameList = new ArrayList<String>();
			nameList.add("test.com");
			Ship ship = shipConst.newInstance(Ship.ShipSize.Mid, nameList);
			int locNum = 28;
			HashMap<Integer, Ship> shipLocMap = new HashMap<Integer, Ship>();
			ArrayList<PlayField.Direction> result;
			ArrayList<PlayField.Direction> expected;
			int caseNum = 0;
			boolean succeeded = true;
			// case 1: all available
			caseNum++;
			shipLocMap.put(4, ship);
			shipLocMap.put(52, ship);
			shipLocMap.put(25, ship);
			shipLocMap.put(31, ship);
			shipLocation.set(playField, shipLocMap);
			result = initDirectionList();
			testMethod.invoke(playField, locNum, Ship.ShipSize.Mid, result);
			expected = initDirectionList();
			System.out.println(Arrays.toString(result.toArray()));
			if(!Arrays.equals(result.toArray(), expected.toArray())){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}
			// case 2: up unavailable
			caseNum++;
			shipLocMap = new HashMap<Integer, Ship>();
			shipLocMap.put(12, ship);
			shipLocation.set(playField, shipLocMap);
			result = initDirectionList();
			testMethod.invoke(playField, locNum, Ship.ShipSize.Mid, result);
			expected = initDirectionList();
			expected.remove(PlayField.Direction.Up);
			System.out.println(Arrays.toString(result.toArray()));
			if(!Arrays.equals(result.toArray(), expected.toArray())){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}
			// case 3: down unavailable
			caseNum++;
			shipLocMap = new HashMap<Integer, Ship>();
			shipLocMap.put(44, ship);
			shipLocation.set(playField, shipLocMap);
			result = initDirectionList();
			testMethod.invoke(playField, locNum, Ship.ShipSize.Mid, result);
			expected = initDirectionList();
			expected.remove(PlayField.Direction.Down);
			System.out.println(Arrays.toString(result.toArray()));
			if(!Arrays.equals(result.toArray(), expected.toArray())){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}
			// case 4: left unavailable
			caseNum++;
			shipLocMap = new HashMap<Integer, Ship>();
			shipLocMap.put(26, ship);
			shipLocation.set(playField, shipLocMap);
			result = initDirectionList();
			testMethod.invoke(playField, locNum, Ship.ShipSize.Mid, result);
			expected = initDirectionList();
			expected.remove(PlayField.Direction.Left);
			System.out.println(Arrays.toString(result.toArray()));
			if(!Arrays.equals(result.toArray(), expected.toArray())){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}
			// case 5: right unavailable
			caseNum++;
			shipLocMap = new HashMap<Integer, Ship>();
			shipLocMap.put(30, ship);
			shipLocation.set(playField, shipLocMap);
			result = initDirectionList();
			testMethod.invoke(playField, locNum, Ship.ShipSize.Mid, result);
			expected = initDirectionList();
			expected.remove(PlayField.Direction.Right);
			System.out.println(Arrays.toString(result.toArray()));
			if(!Arrays.equals(result.toArray(), expected.toArray())){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}
			// case 6: all unavailable
			caseNum++;
			shipLocMap = new HashMap<Integer, Ship>();
			shipLocMap.put(12, ship);
			shipLocMap.put(44, ship);
			shipLocMap.put(26, ship);
			shipLocMap.put(30, ship);
			shipLocation.set(playField, shipLocMap);
			result = initDirectionList();
			testMethod.invoke(playField, locNum, Ship.ShipSize.Mid, result);
			expected = new ArrayList<PlayField.Direction>();
			System.out.println(Arrays.toString(result.toArray()));
			if(!Arrays.equals(result.toArray(), expected.toArray())){
				System.out.format("case %s failed\n", caseNum);
				succeeded = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("### End testCheckShipOnTheWay ###");
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
				Constructor<Ship> shipConst = Ship.class.getDeclaredConstructor(Ship.ShipSize.class, ArrayList.class);
				shipConst.setAccessible(true);
				ArrayList<String> shipNameList = new ArrayList<String>();
				shipNameList.add("Google.com");
				Ship ship = null;
				for(Ship.ShipSize shipSize : Ship.ShipSize.values()){ // for each ship size
					ship = shipConst.newInstance(shipSize, shipNameList);
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

	private static ArrayList<PlayField.Direction> initDirectionList(){
		ArrayList<PlayField.Direction> directionList = new ArrayList<PlayField.Direction>();
		for(PlayField.Direction direction : PlayField.Direction.values()){
			directionList.add(direction);
		}
		return directionList;
	}
 }
