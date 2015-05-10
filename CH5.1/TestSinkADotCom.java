/*
Method				test code	result
main
getRandomIntUpTo	ok			ok
validateFieldSize	ok
init
calcTotalShipNum
play
validateInput
(test private method through main method one by one)
*/

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class TestSinkADotCom {
	public static void main(String[] args) {
//		testGetRandomIntUpTo();
		try {
			testValidateFieldSize();
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}
		
		
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
	
	private static void testValidateFieldSize() throws Exception{
		int testNum = 0;
		Class<?> SinkADotComClass = SinkADotCom.class;
		Method testMethod = SinkADotComClass.getDeclaredMethod("validateFieldSize", int.class, int.class);
		testMethod.setAccessible(true);
		
		// normal
		try {
			testNum++;
			testMethod.invoke(SinkADotCom.class, 10, 10);
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
			testMethod.invoke(SinkADotCom.class, 3, 50);
			
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
			testMethod.invoke(SinkADotCom.class, 5, 10);
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
			testMethod.invoke(SinkADotCom.class, 10, 5);
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
			testMethod.invoke(SinkADotCom.class, 26, 5);
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
			testMethod.invoke(SinkADotCom.class, 5, 26);
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
			testMethod.invoke(SinkADotCom.class, 9, 5);
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
			testMethod.invoke(SinkADotCom.class, 9, 15);
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
			testMethod.invoke(SinkADotCom.class, 4, 10);
			
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
			testMethod.invoke(SinkADotCom.class, 10, 4);
			
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
			testMethod.invoke(SinkADotCom.class, 27, 5);
			
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
			testMethod.invoke(SinkADotCom.class, 5, 27);
			
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
			testMethod.invoke(SinkADotCom.class, 6, 7);
			
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
			testMethod.invoke(SinkADotCom.class, 8, 17);
			
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
	}
}
