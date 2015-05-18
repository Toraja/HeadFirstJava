import java.lang.reflect.Field;

public class StubPlayField extends PlayField {
	public static void main(String[] args) {
		StubPlayField stubField = new StubPlayField();
		stubField.setFieldLengthAndWidth(7, 7);
		PlayField field = stubField;
		System.out.println(field.getFieldLength());
		System.out.println(field.getFieldWidth());
	}
	
	public StubPlayField(){
		
	}
	
	public void setFieldLengthAndWidth(int fieldLength, int fieldWidth){
		try {
			Field field1 = PlayField.class.getDeclaredField("fieldLength");
			Field field2 = PlayField.class.getDeclaredField("fieldWidth");
			field1.setAccessible(true);
			field2.setAccessible(true);
			field1.set(this, fieldLength);
			field2.set(this, fieldWidth);
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
