/*
Method					completed
main
getRandomIntUpTo		yes
convCoordinateToLocNum	yes
validateFieldSize		yes
init
calcTotalShipNum		yes
play
initValidationArrays	yes
validateInput			yes
*/

import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SinkADotCom{
	
	private static List<String> charList;
	private static List<String> numList;
	private static int numTrial;
	private static String coordiChar;
	private static String coordiNum;
	private static PlayField playField;
	private static Map<String, Integer> charToNumMap = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		
	}
	
	public static int getRandomIntUpTo(int maxNum){
		return (int)(Math.random() * (maxNum + 1));
	}
	
	public static int convCoordinateToLocNum(){
		int x = Integer.parseInt(SinkADotCom.coordiNum);
		int y = SinkADotCom.charList.indexOf(SinkADotCom.coordiChar);
		int locNum = y * SinkADotCom.playField.getFieldWidth() + x;

			return locNum;
	}
	
	private static void validateFieldSize(int fieldLength, int fieldWidth) throws IllegalArgumentException{
		final String errorMsg1 = "Field length or Field width is too %s";
		final String errorMsg2 = "Field size (Field length * Field width) is too %s";
	
		if(fieldLength < 5 || fieldWidth < 5){
			throw new IllegalArgumentException(String.format(errorMsg1, "small"));
		}
		else if(fieldLength > 26 || fieldWidth > 26){
			throw new IllegalArgumentException(String.format(errorMsg1, "big"));
		}
		else if(fieldLength * fieldWidth < 45){
			throw new IllegalArgumentException(String.format(errorMsg2, "small"));
		}
		else if(fieldLength * fieldWidth > 135){
			throw new IllegalArgumentException(String.format(errorMsg2, "big"));
		}
	}
	
	private static int calcTotalShipNum(int fieldLength, int fieldWidth){
		final float fieldShipRatio = 15f;
		return Math.round(fieldLength * fieldWidth / fieldShipRatio);
	}
	
	private static void initValidationArrays(int fieldLength, int fieldWidth){
		String[] allCharArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] allNumArray = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26" };
		
		SinkADotCom.charList = Arrays.asList(Arrays.copyOf(allCharArray, fieldLength));
		SinkADotCom.numList = Arrays.asList(Arrays.copyOf(allNumArray, fieldWidth));
		
//		for(int i = 0; i < SinkADotCom.charList.size(); i++){
//			SinkADotCom.charToNumMap.put(SinkADotCom.charList.get(i), i + 1);
//		}
	}
	
	private static boolean validateInput(String input){
		if (input == null || input.length() < 2) { // 
			System.out.println("Invalid input: " + input);
			return false;
		}
		
		SinkADotCom.coordiChar = input.substring(0, 1).toUpperCase();
		SinkADotCom.coordiNum = input.substring(1);
		boolean isValid = SinkADotCom.charList.contains(coordiChar) && SinkADotCom.numList.contains(coordiNum);
		
		if (isValid) { // 
			SinkADotCom.numTrial++;
		}
		
		return isValid;
	}
}
