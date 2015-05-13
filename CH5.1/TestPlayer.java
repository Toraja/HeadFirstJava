//			test drive	result
//shoot		ok			ok
//disarm	ok			ok

public class TestPlayer{
	public static void main(String[] args) {
//		testShoot();
		testDisarm();
	}
	
	private static void testShoot(){
		Player player = new Player();
		try {
			for(int i = 0; i < 5; i++){
				String coordinate = player.shoot();
				System.out.println("trial " + i + ": " + coordinate);
			}
		} 
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println("testShoot failed");
		}
	}
	
	private static void testDisarm(){
		try {
			Player player = new Player();
			player.shoot();
			player.disarm();
			player.shoot();
		} 
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println("Test succeeded");
		}
		
	}
}
