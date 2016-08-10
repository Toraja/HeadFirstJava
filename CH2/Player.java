import java.lang.Math;

class Player{
	int numGuessed;
	String name;

	public Player(String name){
		this.name = name;
	}

	public void guessNumber(){
		this.numGuessed = (int)(Math.random() * 10);
	}

	public int tellsNumber(){
		return this.numGuessed;
	}

	public String getName(){
		return this.name;
	}
}
