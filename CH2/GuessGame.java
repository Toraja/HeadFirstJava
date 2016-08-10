import java.util.ArrayList;
import java.lang.Math;

class GuessGame{
	Player p1;
	Player p2;
	Player p3;
	ArrayList<Player> correctPlayers = new ArrayList<Player>();
	int randomNum;		// 0 - 9

	public GuessGame(){
		this.p1 = new Player("p1");
		this.p2 = new Player("p2");
		this.p3 = new Player("p3");
	}

	void play(){
		//set a random number and have players guessed it
		this.randomNum =  (int)(Math.random() * 10);
		p1.guessNumber();
		p2.guessNumber();
		p3.guessNumber();

		//compare numbers and construct congrats message
		String congratsMsg = "";
		System.out.println("The number is " + randomNum);
		System.out.println(p1.getName() + " guessed " + p1.tellsNumber());
		if(p1.tellsNumber() == randomNum){
			congratsMsg += p1.getName();
		}
		System.out.println(p2.getName() + " guessed " + p2.tellsNumber());
		if(p2.tellsNumber() == randomNum){
			if(! congratsMsg.isEmpty()){
				congratsMsg += " and ";
			}
			congratsMsg += p2.getName();
		}
		System.out.println(p3.getName() + " guessed " + p3.tellsNumber());
		if(p3.tellsNumber() == randomNum){
			if(! congratsMsg.isEmpty()){
				congratsMsg += " and ";
			}
			congratsMsg += p3.getName();
		}

		if(congratsMsg.isEmpty()){
			System.out.println("Sorry, no one was correct.");
		}
		else{
			System.out.println("Congraturations!! " + congratsMsg + " got the correct number!!");
		}
	}
}
