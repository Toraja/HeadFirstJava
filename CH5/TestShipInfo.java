public class TestShipInfo{
	public static void main(String[] args){
		// testGetSetShipName();
		
		//testGetSetShipAssigned();		
		
		testGetRandomShipNames();
	}
	
	private static void testGetSetShipName(){
		for(int i = 0; i < ShipInfo.getShipNamesLength(); i++){
			System.out.print(i + ": " + ShipInfo.getShipNames(i) + " ");
		}
		System.out.println();
		System.out.println();
		
		String newShipName = "Mario.com";
		int index = 3;
		ShipInfo.setShipNames(newShipName, index);
		System.out.print("New ship name " + newShipName + " has been set to ");
		System.out.println(index);
		System.out.println();
		
		for(int i = 0; i < ShipInfo.getShipNamesLength(); i++){
			System.out.print(i + ": " + ShipInfo.getShipNames(i) + " ");
		}
		System.out.println();
	}
	
	private static void testGetSetShipAssigned(){
		for(int i = 0; i < ShipInfo.getShipNamesAssignedLength(); i++){
			System.out.print(i + ": " + ShipInfo.getShipNamesAssigned(i) + " ");
		}
		System.out.println();
		System.out.println();
		
		boolean truth = true;
		int index = 8;
		ShipInfo.setShipNamesAssigned(truth, index);
		System.out.print("New boolean value " + truth + " has been set to ");
		System.out.println(index);
		System.out.println();
		
		for(int i = 0; i < ShipInfo.getShipNamesAssignedLength(); i++){
			System.out.print(i + ": " + ShipInfo.getShipNamesAssigned(i) + " ");
		}
		System.out.println();
		
	}
	
	private static void testGetRandomShipNames(){
		try{
			for(int i = 0; i < 11; i++){
				System.out.println(ShipInfo.getRandomShipNames() + ";");
			}
		}
		catch(Exception e){
			System.err.println("Error");
		}
	}
}
