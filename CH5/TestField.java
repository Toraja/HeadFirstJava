public class TestField {
	public static void main(String[] args){
		try{
			Field field = new Field(3,7,7);
			for(int i = 0; i < 3; i++){
				System.out.println(field.getShips(i).getName());
			}
			for(int i = 0; i < ShipInfo.getShipNamesAssignedLength(); i++){
				System.out.println(ShipInfo.getShipNamesAssigned(i));
			}
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
}
