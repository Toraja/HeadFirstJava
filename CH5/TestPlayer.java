public class TestPlayer{
	public static void main(String[] args){
		try{
			Field field = new Field(3, 7, 7);
			
			Player player = new Player();
			
			while(field.getShipNum() > 0){
				player.shoot(field);
			}
		}
		catch(Exception e){
			System.err.println("Program halted");
		}
	}
}
