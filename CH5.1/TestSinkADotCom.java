/*
Method				test code	result
main
getRandomIntUpTo	ok			ok
validateFieldSize	
init
calcTotalShipNum
play
validateInput
(test private method through main method one by one)
*/
public class TestSinkADotCom {
	public static void main(String[] args) {
//		testGetRandomIntUpTo();
		
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
	
	private static void testValidateFieldSize(){
		ArrayList<Ship> shipList = new ArrayList<Ship>();
		int testNum = 0;
		
		// normal
		try {
			testNum++;
			Field field = new Field(10, 10, shipList);
		} 
		catch (IlleagalArgumentException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// all error
		try {
			testNum++;
			Field field = new Field(3, 50, shipList);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (IlleagalArgumentException e) { 
			// success
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - length - normal
		try {
			testNum++;
			Field field = new Field(5, 10, shipList);
		} 
		catch (IlleagalArgumentException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - width - normal
		try {
			testNum++;
			Field field = new Field(10, 5, shipList);
		} 
		catch (IlleagalArgumentException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - length - normal
		try {
			testNum++;
			Field field = new Field(26, 5, shipList);
		} 
		catch (IlleagalArgumentException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - width - normal
		try {
			testNum++;
			Field field = new Field(5, 26, shipList);
		} 
		catch (IlleagalArgumentException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - size - normal
		try {
			testNum++;
			Field field = new Field(9, 5, shipList);
		} 
		catch (IlleagalArgumentException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - size - normal
		try {
			testNum++;
			Field field = new Field(9, 15, shipList);
		} 
		catch (IlleagalArgumentException e) { 
			System.out.println("Case " + testNum + " failed");
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - length - error
		try {
			testNum++;
			Field field = new Field(4, 10, shipList);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (IlleagalArgumentException e) { 
			// success
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - width - error
		try {
			testNum++;
			Field field = new Field(10, 4, shipList);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (IlleagalArgumentException e) { 
			// success
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - length - error
		try {
			testNum++;
			Field field = new Field(27, 5, shipList);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (IlleagalArgumentException e) { 
			// success
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - width - error
		try {
			testNum++;
			Field field = new Field(5, 27, shipList);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (IlleagalArgumentException e) { 
			// success
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// lower boundary - size - error
		try {
			testNum++;
			Field field = new Field(6, 7, shipList);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (IlleagalArgumentException e) { 
			// success
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
		
		// upper boundary - size - error
		try {
			testNum++;
			Field field = new Field(8, 17, shipList);
			
			System.out.println("Case " + testNum + " failed");
		} 
		catch (IlleagalArgumentException e) { 
			// success
		}
		catch (Exception e) {
			System.out.println("Case " + testNum + " failed");
		}
	}
}
