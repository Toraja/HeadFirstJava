public abstract class Animal{
	// TODO store picture
	Food food;					// Food Enum
	String noise;				// noise an animal makes
	String roamingType;			// how an animal roams
	int hunger;					// hunger lever (how much a animal eats; min 1 - 10 max)
	int picHeight;				// height of the picture
	int picWidth;				// width of the picture
	int locationX;				// X coordinate
	int locationY;				// Y coordinate

	void makeNoise(){
		System.out.println(this.getClass().getSimpleName() + " says " + this.noise);
	}

	void eat(){
		// for (int i = 0; i < this.hunger; i++){
			// System.out.println(this.getClass().getSimpleName() + " is eating " + this.food);
		// }
		String foodAdjustedForHungerLevel = new String(new char[this.hunger]).replace("\0", (this.food.toString() + " ").subSequence(0, this.food.toString().length() + 1));
		System.out.println(this.getClass().getSimpleName() + " is eating " + foodAdjustedForHungerLevel + "...");
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
		d.fetch(new Frisbee());
		d.fetch(new Boomerang());
		d.fetch(new Exception());
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
	// but cannot be used here as those variables are non-static now
	// static {
		// Canine.food = Food.meat;
		// Canine.roamingType = "in a herd";
		// Canine.hunger = 4;
	// }

	// abstract class can have a constructor and use "this" keyword
	Canine(){
		this.hunger = 4;
		this.roamingType = "in a herd";
		this.food = Food.meat;
	}
}

abstract class Feline extends Animal{

	Feline() {
		this.food = Food.meat;
	}

	void catwalk(){
		System.out.println(this.getClass().getSimpleName() + " is cat-walking");
	}
}

abstract class Hippopotamine extends Animal{

	Hippopotamine() {
		this.food = Food.grass;
	}
}

class Dog extends Canine{

	Dog() {
		this.noise = "bowwow";
	}

	public Catchable fetch(Throwable t){
		String thisName = this.getClass().getSimpleName();
		String throwableName = t.getClass().getSimpleName();
		if(t instanceof Catchable){
			System.out.println(thisName + " caught " + throwableName);
			return (Catchable)t;
		}
		else{
			System.out.println(thisName + " failed to catch " + throwableName);
			return null;
		}
	}
}

class Wolf extends Canine{

	Wolf() {
		this.hunger = 6;
		this.noise = "owooooo";
	}
}

class Cat extends Feline{

	Cat() {
		this.hunger = 2;
		this.noise = "meow";
		this.roamingType = "alone";
	}
}

class Tiger extends Feline{

	Tiger() {
		this.hunger = 7;
		this.noise = "roar";
		this.roamingType = "alone";
	}
}

class Lion extends Feline{

	Lion() {
		this.hunger = 8;
		this.noise = "gurrrr";
		this.roamingType = "in a herd";
	}
}

class Hippopotamus extends Hippopotamine{

	Hippopotamus() {
		this.hunger = 9;
		this.noise = ".....";
		this.roamingType = "in a herd";
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

