public class TestShip{
	public static void main(String[] args){
		Ship ship = new Ship();
		ship.setName("mario");
		System.out.println(ship.getName());
		ship.setShipHP(3);
		System.out.println(ship.getShipHP());
		
	}
}