public class TestShip{
	public static void main(String[] args){
		String shipName = "Google.com";
		ShipInfo.ShipSize shipSize = ShipInfo.ShipSize.SMALL;
		System.out.println("Params for constructor: " + shipName + ", " + shipSize);
		
		// Test Constructor
		Ship ship = new Ship(shipName, shipSize);
		System.out.println("Ship name: " + ship.getName());
		System.out.println("Ship size: " + ship.getShipSizeType());
		System.out.println("Ship HP should be \"2\": " + ship.getShipHP());
		
		ship.setName("mario");
		System.out.println(ship.getName());
		ship.setShipHP(3);
		System.out.println(ship.getShipHP());
		ship.setShipSizeType(ShipInfo.ShipSize.MID);
		System.out.println(ship.getShipSizeType());
		
	}
}
