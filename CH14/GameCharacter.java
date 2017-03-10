import java.io.*;

public class GameCharacter implements Serializable{
	int power;
	String type;
	String[] weapons;

	public GameCharacter(int power, String type, String[] weapons){
		this.power = power;
		this.type = type;
		this.weapons = weapons;
	}

	public int getPower(){
		return this.power;
	}

	public void setPower(int power){
		this.power = power;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getWeapons(){
		String weaponList = "";
		for(int i = 0; i < this.weapons.length; i++){
			weaponList += this.weapons[i] + " ";
		}
		return weaponList;
	}

	// public String[] getWeapons(){
		// return this.weapons;
	// }

	public void setWeapons(String[] weapons){
		this.weapons = weapons;
	}
}
