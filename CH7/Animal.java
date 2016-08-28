public abstract class Animal{
	// TODO store picture
	static Food food;			// Food Enum
	static String noise;		// noise an animal makes
	static String roamingType;	// how an animal roams
	static int hunger;					// hunger lever (how much a animal eats; min 1 - 10 max)
	int picHeight;				// height of the picture
	int picWidth;				// width of the picture
	int locationX;				// X coordinate
	int locationY;				// Y coordinate

	void makeNoise(){
		System.out.println(this.getClass().getSimpleName() + " says " + this.noise);
	}

	void eat(){
		for (int i = 0; i < this.hunger; i++){
			System.out.println(this.getClass().getSimpleName() + " is eating " + this.food);
		}
	}

	void sleep(){
		System.out.println(this.getClass().getSimpleName() + " is Zzz...");
	}

	void roam(){
		// TODO move an image
		System.out.println(this.getClass().getSimpleName() + " is roaming " + this.roamingType);
	}

	public static void main(String[] args){
		Dog d = new Dog();
		d.makeNoise();
		d.roam();
		d.eat();
		System.out.println();

		Wolf w = new Wolf();
		w.makeNoise();
		w.roam();
		w.eat();
		System.out.println();

		Cat c = new Cat();
		c.makeNoise();
		c.roam();
		c.eat();
		System.out.println();

		Tiger t = new Tiger();
		t.makeNoise();
		t.roam();
		t.eat();
		System.out.println();

		Lion l = new Lion();
		l.makeNoise();
		l.roam();
		l.eat();
		System.out.println();

		Hippopotamus h = new Hippopotamus();
		h.makeNoise();
		h.roam();
		h.eat();
		System.out.println();

		Wolf w2 = new Wolf();
		w2.makeNoise();
		w2.roam();
		w2.eat();
		System.out.println();

		Shiba pochi = new Shiba("pochi");
		pochi.beFriendly();
		pochi.greet();
		pochi.sleep();
		pochi.makeNoise();
		pochi.roam();
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
	// instance/class variable can be initialized in this way
	// but it seems overkill to declare new? variables
	// Food food = Food.meat;
	// int hunger = 4;

	// this seems the best way for initializing class variables
	static {
		Canine.food = Food.meat;
		Canine.roamingType = "in a herd";
		Canine.hunger = 4;
	}

	// abstract class can have a constructor and use "this" keyword
	// Canine(){
		// this.hunger = 4;
		// this.roamingType = "in a herd";
		// this.food = Food.meat;
	// }
}

abstract class Feline extends Animal{

	static {
		Feline.food = Food.meat;
	}

	void catwalk(){
		System.out.println(this.getClass().getSimpleName() + " is cat-walking");
	}
}

abstract class Hippopotamine extends Animal{

	static {
		Hippopotamine.food = Food.grass;
	}
}

class Dog extends Canine{

	static {
		Dog.noise = "bowwow";
	}
}

class Wolf extends Canine{

	static {
		Wolf.hunger = 6;
		Wolf.noise = "owooooo";
	}

	@Override
	void makeNoise(){
		System.out.println(this.getClass().getSimpleName() + " says " + Wolf.noise);
	}

}

class Cat extends Feline{

	static {
		Cat.hunger = 2;
		Cat.noise = "meow";
		Cat.roamingType = "alone";
	}
}

class Tiger extends Feline{

	static {
		Tiger.hunger = 7;
		Tiger.noise = "roar";
		Tiger.roamingType = "alone";
	}
}

class Lion extends Feline{

	static {
		Lion.hunger = 8;
		Lion.noise = "gurrrr";
		Lion.roamingType = "in a herd";
	}
}

class Hippopotamus extends Hippopotamine{

	static {
		Hippopotamus.hunger = 9;
		Hippopotamus.noise = ".....";
		Hippopotamus.roamingType = "in a herd";
	}
}

interface Pet {
	void beFriendly();
	void greet();
	void sleep();
}

class PetDog extends Dog implements Pet {
	String name;

	public PetDog(String name){
		this.name = name;
	}

	@Override
	public void beFriendly(){
		System.out.println(this.name + " is being friednly: lick lick lick");
	}
	@Override
	public void greet(){
		System.out.println(this.name + " is greeting: Pat pat pat");
	}
	@Override
	public void sleep(){
		System.out.println(this.name + " is sleeping: Zzzzzzzzzzzzzzzzzzzzzzzz...");
	}
}

class Shiba extends PetDog{
	public Shiba(String name){
		super(name);
	}
}
