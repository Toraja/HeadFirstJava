import java.lang.reflect.Field;

public class StubPlayField extends PlayField {
	public static void main(String[] args) {
		PlayField field = new StubPlayField(7, 7);
		System.out.println(field.getFieldLength());
	}
	
	
	// set via setter rather than constructor
	public StubPlayField(int fieldLength, int fieldWidth){
		try {
			Field field1 = PlayField.class.getDeclaredField("fieldLength");
					Field field2 = PlayField.class.getDeclaredField("fieldWidth");
					field1.setAccessible(true);
					field2.setAccessible(true);
					field1.set(fieldLength);
		field2.set(fieldWidth);
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
