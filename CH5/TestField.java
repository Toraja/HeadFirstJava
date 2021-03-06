public class TestField {
	public static void main(String[] args){
		//testFieldConst()
		for(int i = 0; i < 5; i++){
			System.out.println("Trial: " + i);
			//testPlaceShips();
			testPlaceShips2();
			System.out.println();
			ShipInfo.resetNameAssignment();
		}
		
		
	}
	static void testFieldConst(){
		try{
			Field field = new Field(3,7,7);
			for(int i = 0; i < 3; i++){
				System.out.println(field.getShips(i).getName());
			}
			for(int i = 0; i < ShipInfo.getShipNamesAssignedLength(); i++){
				System.out.println(ShipInfo.getShipNamesAssigned(i));
			}
			System.out.println(field.getShipLocationLength());
			System.out.println(field.getShipLocationWidth());
			
			ShipInfo.resetNameAssignment();
			System.out.println();
			
			Field another = new Field(4,10,10);
			for(int i = 0; i < 4; i++){
				System.out.println(another.getShips(i).getName());
			}
			for(int i = 0; i < ShipInfo.getShipNamesAssignedLength(); i++){
				System.out.println(ShipInfo.getShipNamesAssigned(i));
			}
			ShipInfo.resetNameAssignment();
			System.out.println();
			
			Field other = new Field(6,12,12);
			for(int i = 0; i < 6; i++){
				System.out.println(other.getShips(i).getName());
			}			
			for(int i = 0; i < ShipInfo.getShipNamesAssignedLength(); i++){
				System.out.println(ShipInfo.getShipNamesAssigned(i));
			}
			ShipInfo.resetNameAssignment();
			System.out.println();
			
			Field error = new Field(11,20,20);
			for(int i = 0; i < 11; i++){
				System.out.println(other.getShips(i).getName());
			}
			for(int i = 0; i < ShipInfo.getShipNamesAssignedLength(); i++){
				System.out.println(ShipInfo.getShipNamesAssigned(i));
			}
			ShipInfo.resetNameAssignment();

		}
		catch(Exception e){
			System.out.println("Error occured");
		}
	}
	static void testPlaceShips(){
		try{
			Field field = new Field(3,7,7);
			for(int i = 0; i < 3; i++){
				System.out.println(field.getShips(i).getName());
			}
			
			field.placeShips();
			
			ShipComponent shipComp;
			
			for(int i = 0; i < field.getFieldLength(); i++){
				for(int j = 0; j < field.getFieldWidth(); j++){
					shipComp = field.getShipLocation(i,j);
					if(shipComp != null){
						System.out.println(i + ", " + j + ", " + shipComp + ", " + shipComp.getParentShip().getName());
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Error occured");
		}
		
	}
	
	static void testPlaceShips2(){
		try{
			Field field = new Field(3,7,7);
			field.placeShips();
			int count = 0;
			ShipComponent shipComp;
			
			for(int i = 0; i < field.getFieldLength(); i++){
				for(int j = 0; j < field.getFieldWidth(); j++){
					shipComp = field.getShipLocation(i,j);
					if(shipComp != null){
						count++;
					}
				}
			}
			if(count < 9){
				System.out.println("Collision Occured: " + (9 - count));
			}
		}
		catch(Exception e){
			System.out.println("Error occured");
		}
	}
}
