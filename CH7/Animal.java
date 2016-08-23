public abstract class Animal{
	// TODO store picture
	Food food;		// TODO create Food Enum
	int hunger;		// hunger lever (how much a animal eats; min 1 - 10 max)
	int picHeight;		// height of the picture
	int picWidth;		// width of the picture
	int locationX;		// X coordinate
	int locationY;		// Y coordinate

	abstract void makeNoise();

	void eat(){
		for (int i = 0; i < this.hunger; i++){
			System.out.println("Eating " + this.food);
		}
	}

	void sleep(){
		System.out.println("Zzz...");
	}

	void roam(){
		//TODO implement basic roaming
	}

	public static void main(String[] args){
		//Animal dai = new Dog();
		//dai.eat();
		//dai.makeNoise();
		
		//Pet dai = new PetDog();
		//dai.beFriendly();
		//dai.greet();
		//dai.sleep();
		//dai.makeNoise();

		Shiba pochi = new Shiba();
		pochi.beFriendly();
		pochi.greet();
		pochi.sleep();
	}
}

enum Food{
	grass(1), meat(2);

	int id;

	Food(int id){
		this.id = id;
	}
}

abstract class Canine extends Animal{
	//Food food = Food.meat;
	//int hunger = 4;

	// abstract class can have a constructor
	Canine(){
		this.hunger = 4;
		this.food = Food.meat;
	}
	void roam(){
		//TODO move in packs
	}
}

abstract class Feline extends Animal{
	Food food = Food.meat;

	void catwalk(){
		System.out.println("cat walking");
	}
	
	void roam(){
		//TODO move alone
	}
}

abstract class Hippopotamine extends Animal{
	Food food = Food.grass;
}

class Dog extends Canine{
	Dog(){
		//this.hunter = super.hunter;
		//this.hunter = 4;
	}

	@Override
	void makeNoise(){
		System.out.println("bowwow");
	}
}

class Wolf extends Canine{
	Wolf() {
		this.hunger = 6;
	}

	@Override
	void makeNoise(){
		System.out.println("owooooo");
	}
}

class Cat extends Feline{
	Cat() {
		this.hunger = 2;
	}

	@Override
	void makeNoise(){
		System.out.println("meow");
	}
}

class Tiger extends Feline{
	Tiger() {
		this.hunger = 7;
	}
	
	@Override
	void makeNoise(){
		System.out.println("roar");
	}
}

class Lion extends Feline{
	Lion() {
		this.hunger = 8;
	}
	
	@Override
	void makeNoise(){
		System.out.println("gurrrr");
	}
}

class Hippopotamus extends Hippopotamine{
	Hippopotamus() {
		this.hunger = 9;
	}
	
	@Override
	void makeNoise(){
		System.out.println("....");
	}
}

interface Pet {
	void beFriendly();
	void greet();
	void sleep();
}

class PetDog extends Dog implements Pet {
	@Override
	public void beFriendly(){
		System.out.println("lick lick lick");
	}
	@Override
	public void greet(){
		System.out.println("Pat pat pat");
	}
	@Override
	public void sleep(){
		System.out.println("Zzzzzzzzzzzzzzzzzzzzzzzz...");
	}
}

class Shiba extends PetDog{

}
