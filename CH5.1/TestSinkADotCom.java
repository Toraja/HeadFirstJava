/*
Method					test code	result
main	
getRandomIntUpTo		ok			ok
convCoordinateToLocNum	ok			ok
validateFieldSize		ok			ok
init					*tested in main
calcTotalShipNum		ok			ok
play					*tested in main
initValidationArrays	ok			ok
validateInput			ok			ok
*/

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestSinkADotCom {

	static String testFailedMsg = "Case %s failed. %s\n";
	static Class<?> testClass = SinkADotCom.class;
	
	public static void main(String[] args) {
		System.out.println("*** Start TestSinkADotCom *** ");
		
		// testGetRandomIntUpTo();
		// testValidateFieldSize();
		//testCalcTotalShipNum();
		//testInitValidationArrays();
		testValidateInput();	
		//testConvCoordinateToLocNum();
			
		System.out.println("*** The end of the test ***");
	}
	
	private static void testGetRandomIntUpTo(){
		String methodName = null;
		try {
			methodName = (new TestSinkADotCom()).getClass().getDeclaredMethods()[0].getName();
			
		} catch (Exception e) {
			System.err.println("The specified method was not found");
		}
		for(int i = 0; i < 10; i++){	
			int maxNum = (int)(Math.random() * 10);
			int randomNum = SinkADotCom.getRandomIntUpTo(maxNum);
			System.out.println(methodName + ": trial" + (i + 1));
			System.out.print("Max num: " + maxNum + " - " + "Random num: " + randomNum + " >>> ");
			
			if (randomNum >= 0 && randomNum <= maxNum) { // 
				System.out.println("success");
			} else { // 
				System.out.println("failed");
			}
		}
	}
	
	private static void testConvCoordinateToLocNum(){
		System.out.println("### Start testConvCoordinateToLocNum ###");

		try {
			// test on 12 x 10 field
			String[] testInput = {"C3", "e7", "L9"};
			int[] expectedValues = {23, 47, 119};
		
			StubPlayField spf = new StubPlayField();
			spf.setFieldLengthAndWidth(12, 10);
		
			Method helperMethod1 = testClass.getDeclaredMethod("initValidationArrays", int.class, int.class);
			Method helperMethod2 = testClass.getDeclaredMethod("validateInput", String.class);
			helperMethod1.setAccessible(true);
			helperMethod2.setAccessible(true);
			helperMethod1.invoke(testClass, 12, 10);
			
			Field field = testClass.getDeclaredField("playField");
			field.setAccessible(true);
			field.set(testClass, spf);

			for(int i = 0; i < testInput.length; i++){
				helperMethod2.invoke(testClass, testInput[i]);
				int locNum = SinkADotCom.convCoordinateToLocNum();
				if (locNum != expectedValues[i]) { // 
					System.out.printf(testFailedMsg, "12 x 10 - " + (i + 1), " expedted: " + expectedValues[i] + " - actual: " + locNum);
				}
			}
			
			// test on 7 x 7 field
			String[] testInput2 = {"C3", "d6", "f7"};
			int[] expectedValues2 = {17, 27, 42};
		
			spf.setFieldLengthAndWidth(7, 7);
			helperMethod1.invoke(testClass, 7, 7);
			field.set(testClass, spf);
			
			for(int i = 0; i < testInput2.length; i++){
				helperMethod2.invoke(testClass, testInput2[i]);
				int locNum = SinkADotCom.convCoordinateToLocNum();
				if (locNum != expectedValues2[i]) { // 
					System.out.printf(testFailedMsg, "7 x 7 - " + (i + 1), " expedted: " + expectedValues2[i] + " - actual: " + locNum);
				}
			}
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}

		System.out.println("### End testConvCoordinateToLocNum ###");
	}
	
	private static void testValidateFieldSize(){
	
		System.out.println("### Start testValidateFieldSize ###");
	
		int testNum = 0;
		Method testMethod = null;
		try{
			testMethod = testClass.getDeclaredMethod("validateFieldSize", int.class, int.class);
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		testMethod.setAccessible(true);
		
		// normal
		try {
			testNum++;
			testMethod.invoke(testClass, 10, 10);
		} 
		catch (InvocationTargetException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// all error
		try {
			testNum++;
			testMethod.invoke(testClass, 3, 50);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (InvocationTargetException e) { 
			// success
			System.out.println(testNum + ": " + e.getCause().getMessage());
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
			e.printStackTrace();
		}
		
		// lower boundary - length - normal
		try {
			testNum++;
			testMethod.invoke(testClass, 5, 10);
		} 
		catch (InvocationTargetException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - width - normal
		try {
			testNum++;
			testMethod.invoke(testClass, 10, 5);
		} 
		catch (InvocationTargetException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - length - normal
		try {
			testNum++;
			testMethod.invoke(testClass, 26, 5);
		} 
		catch (InvocationTargetException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - width - normal
		try {
			testNum++;
			testMethod.invoke(testClass, 5, 26);
		} 
		catch (InvocationTargetException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - size - normal
		try {
			testNum++;
			testMethod.invoke(testClass, 9, 5);
		} 
		catch (InvocationTargetException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - size - normal
		try {
			testNum++;
			testMethod.invoke(testClass, 9, 15);
		} 
		catch (InvocationTargetException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - length - error
		try {
			testNum++;
			testMethod.invoke(testClass, 4, 10);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (InvocationTargetException e) { 
			// success
			System.out.println(testNum + ": " + e.getCause().getMessage());
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
			e.printStackTrace();
		}
		
		// lower boundary - width - error
		try {
			testNum++;
			testMethod.invoke(testClass, 10, 4);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (InvocationTargetException e) { 
			// success
			System.out.println(testNum + ": " + e.getCause().getMessage());
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
			e.printStackTrace();
		}
		
		// upper boundary - length - error
		try {
			testNum++;
			testMethod.invoke(testClass, 27, 5);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (InvocationTargetException e) { 
			// success
			System.out.println(testNum + ": " + e.getCause().getMessage());
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
			e.printStackTrace();
		}
		
		// upper boundary - width - error
		try {
			testNum++;
			testMethod.invoke(testClass, 5, 27);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (InvocationTargetException e) { 
			// success
			System.out.println(testNum + ": " + e.getCause().getMessage());
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
			e.printStackTrace();
		}
		
		// lower boundary - size - error
		try {
			testNum++;
			testMethod.invoke(testClass, 6, 7);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (InvocationTargetException e) { 
			// success
			System.out.println(testNum + ": " + e.getCause().getMessage());
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
			e.printStackTrace();
		}
		
		// upper boundary - size - error
		try {
			testNum++;
			testMethod.invoke(testClass, 8, 17);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (InvocationTargetException e) { 
			// success
			System.out.println(testNum + ": " + e.getCause().getMessage());
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
			e.printStackTrace();
		}
		
		System.out.println("### End testValidateFieldSize ###");
	}

	private static void testCalcTotalShipNum(){
		System.out.println("### Start testCalcTotalShipNum ###");
		
		Method testMethod = null;
		try{
			testMethod = testClass.getDeclaredMethod("calcTotalShipNum", int.class, int.class);
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		testMethod.setAccessible(true);
		int[] fieldLengthForTest = {5, 8, 10, 9};
		int[] fieldWidthForTest = {9, 12, 10, 15};
		int[] expectedValues = {3, 6, 7, 9};
		
		for(int testNum = 0; testNum < expectedValues.length; testNum++){
			try{
				int shipNum = (int)testMethod.invoke(testClass, fieldLengthForTest[testNum], fieldWidthForTest[testNum]);
				testMethod.invoke(testClass, fieldLengthForTest[testNum], fieldWidthForTest[testNum]);
				if (shipNum != expectedValues[testNum]){
					System.out.format(testFailedMsg, testNum + 1, "--- shipNum: " + shipNum);
				}
			}catch(Exception e){
				System.out.format(testFailedMsg, testNum);
				e.printStackTrace();
				return;
			}
		}
		
		System.out.println("### End testCalcTotalShipNum ###");
	}

	private static void testInitValidationArrays(){
		System.out.println("### Start testInitValidationArrays ###");
		
		Method testMethod = null;
		try{
			testMethod = testClass.getDeclaredMethod("initValidationArrays", int.class, int.class);
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		testMethod.setAccessible(true);
		
		// test values
		int[] fieldLengthForTest = {7, 10, 20};
		int[] fieldWidthForTest = {15, 10, 6};
		// invoke testMethod
		for(int testNum = 0; testNum < fieldLengthForTest.length; testNum++){
			List<String> charList = null;
			List<String> numList = null;
			Map<String, Integer> charToNumMap = null;
			try {
				testMethod.invoke(testClass, fieldLengthForTest[testNum], fieldWidthForTest[testNum]); 
				
				// check test result by referring SinkADotCom's class variables
				Field testField1 = testClass.getDeclaredField("charList");
				Field testField2 = testClass.getDeclaredField("numList");
				Field testField3 = testClass.getDeclaredField("charToNumMap");
				testField1.setAccessible(true);
				testField2.setAccessible(true);
				testField3.setAccessible(true);

				charList = (List<String>)testField1.get(null);
				numList = (List<String>)testField2.get(null);
				charToNumMap = (Map<String, Integer>)testField3.get(null);
			} 
			catch (Exception e) { 
				System.out.format(testFailedMsg, testNum + 1, "");
				e.printStackTrace();
			}
			
			if (charList.size() != fieldLengthForTest[testNum]) { // 
				System.out.format(testFailedMsg, testNum + 1, "charList expected: " + fieldLengthForTest[testNum] + " - actual: " + charList.size());
			}
			if (numList.size() != fieldWidthForTest[testNum]) { // 
				System.out.format(testFailedMsg, testNum + 1, "numList expected: " + fieldWidthForTest[testNum] + " - actual: " + numList.size());
			}
			if (charToNumMap.size() != fieldLengthForTest[testNum]) { // 
				System.out.format(testFailedMsg, testNum + 1, "charToNumMap expected: " + fieldLengthForTest[testNum] + " - actual: " + charToNumMap.size());
			}
			System.out.println("charList: " + Arrays.toString(charList.toArray()));
			System.out.println("numList: " + Arrays.toString(numList.toArray()));
			System.out.println("map: " + Arrays.toString(charToNumMap.entrySet().toArray()));
		}
		
		System.out.println("### End testInitValidationArrays ###");
	}
	
	private static void testValidateInput(){
		System.out.println("### Start testValidateInput ###");
		
		Method testMethod = null;
		Method helperMethod = null;
		Field numTrial = null;
		try{
			testMethod = testClass.getDeclaredMethod("validateInput", String.class);
			helperMethod = testClass.getDeclaredMethod("initValidationArrays", int.class, int.class);
			testMethod.setAccessible(true);
			helperMethod.setAccessible(true);
			helperMethod.invoke(testClass, 10, 12);
			numTrial = testClass.getDeclaredField("numTrial");
			numTrial.setAccessible(true);
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		
		// test on 10 x 12 field
		String[] properInputs = {"C4", "A1", "J1", "A12", "J12", "c4", "a1", "j1", "a12", "j12"};
		String[] errorInputs = {"B0", "K3", "D13", "S1", "23", "AB", "1A"};
		
		// regular case
		for(int testNum = 0; testNum < properInputs.length; testNum++){
			boolean valid = false;
			try{
				// the return value should be true
				valid = (boolean)testMethod.invoke(testClass, properInputs[testNum]);
			}catch(Exception e){
				System.out.format("Regular " + testFailedMsg, testNum + 1, "");
				e.printStackTrace();
			}
			if(!valid){
				System.out.format("Regular " + testFailedMsg, testNum + 1, "");
			}
		}

		try {
	
			if((int)numTrial.get(null) != properInputs.length){
				System.out.format("Regular " + testFailedMsg, "", "numTrial is not counted properly");
			}
			numTrial.set(null, 0);
	
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}
		
		// error case
		for(int testNum = 0; testNum < errorInputs.length; testNum++){
			boolean valid = true;
			try{
				// the return value should be false
				valid = (boolean)testMethod.invoke(testClass, errorInputs[testNum]);
			}catch(Exception e){
				System.out.format("Error " + testFailedMsg, testNum + 1, "");
				e.printStackTrace();
			}
			if(valid){
				System.out.format("Error " + testFailedMsg, testNum + 1, "");
			}
		}

		try {
	
			if((int)numTrial.get(null) != 0){
				System.out.format("Error " + testFailedMsg, "", "numTrial is not counted properly");
			}
			numTrial.set(null, 0);
	
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}
		
		System.out.println("### End testValidateInput ###");
	}
}
