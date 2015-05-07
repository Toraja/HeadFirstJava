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
		TestSinkADotCom testClass = new TestSinkADotCom();
		
		testClass.testGetRandomIntUpTo();
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
			
				System.out.println("fail");
			
			}
			
		}
	}
}
