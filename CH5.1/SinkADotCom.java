/*
Method				completed
main
getRandomIntUpTo	yes
validateFieldSize	yes
init
calcTotalShipNum	yes
play
validateInput		
(test private method through main method one by one)
*/

import java.lang.IllegalArgumentException;

public class SinkADotCom{
	
	public static void main(String[] args) {
		
	}
	
	public static int getRandomIntUpTo(int maxNum){
		return (int)(Math.random() * (maxNum + 1));
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
}
