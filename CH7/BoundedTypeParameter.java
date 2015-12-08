public class BoundedTypeParameter{
	public static void main(String[] args){
		trial1();
		//trial2();
		//trial3();
		//trial4();
		//trial5();
	}

	public static void trial1(){
		CanineHandler ch = new CanineHandler();
		Dog d = new Dog();
		Cat c = new Cat();
		System.out.println("d = " + d);
		System.out.println("c = " + c);
		ch.setCanine(d);
		//ch.setCanine(c);	// compile error as Cat is not a subclass of Canine
	}

	public static void trial2(){
		CanineHandler ch = new CanineHandler();
		ch.setString("apple");
	}

	public static void trial3(){
		Box<Canine> b = new Box<Canine>();
		Dog d = new Dog();
		System.out.println("d = " + d);
		b.set(d);
		System.out.println("getd = " + b.get());
	}
	
	public static void trial4(){
		Box<Canine> b = new Box<Canine>();
		Dog d = new Dog();
		Wolf w = new Wolf();
		System.out.println("d = " + d);
		System.out.println("w = " + w);
		b.set(d);
		b.newset(w);
		System.out.println("getd = " + b.get());
		System.out.println("getw = " + b.newget());
	}
	
	//compile error as Cat is not a subclass of Canine
	//public static void trial5(){
		//Box<Canine> b = new Box<Canine>();
		//Dog d = new Dog();
		//Cat c = new Cat();
		//System.out.println("d = " + d);
		//System.out.println("c = " + c);
		//b.set(d);
		//b.newset(c);
		//System.out.println("getd = " + b.get());
		//System.out.println("getc = " + b.newget());
	//}
}

class CanineHandler{

	public <SuperCanine extends Canine> void setCanine(SuperCanine spc){
		System.out.println("spc = " + spc);
	}

	public <SuperCanine extends Canine> void setString(String st){
		System.out.println("st = " + st);
	}
}

class Box<T> {
	T t;
	T nt;

	public void set(T t){
		this.t = t;
	}

	public T get(){
		return t;
	}

	//public void newset(Feline f){	// compile error
	//public void newset(Wolf f){	// compile error
	public <X extends T> void newset(X f){
		this.nt = f;
	}

	public T newget(){
		return nt;
	}

}


