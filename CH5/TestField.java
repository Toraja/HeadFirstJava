public class TestField {
	public static void main(String[] args){
		try{
			Field field = new Field(3,7,7);
			Field another = new Field(4,10,10);
//			Field other = new Field(4,10,10);
//			Field error = new Field(11,20,20);
			
			for(int i = 0; i < 3; i++){
				System.out.println(field.getShips(i).getName());
				
			}
			
			ShipInfo.resetNameAssignment();
			
			for(int i = 0; i < 4; i++){
				System.out.println(another.getShips(i).getName());
				
			}
		}
		catch(Exception e){
			System.out.println("Error occured");
		}
		
	}
}
