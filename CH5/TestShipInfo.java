public class TestShipInfo{
	public static void main(String[] args){
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
}
