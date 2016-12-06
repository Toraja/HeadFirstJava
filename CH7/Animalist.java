import java.util.ArrayList;

public class Animalist<E> extends ArrayList<E>{
	//public boolean add (E e){
		//super.add(e);
	// }

	public static void main (String[] args){
		Animalist<Animal> al = new Animalist<Animal>();
		int randnum;
		for(int i = 0; i < 8; i++){
			randnum = (int)Math.floor(Math.random() * 3);
			switch(randnum % 3){
				case 0:
					al.add(new Dog());
					break;
				case 1:
					al.add(new Cat());
					break;
				case 2:
					al.add(new Hippopotamus());
					break;
				default:
					System.out.println("This should not happen");
					break;
			}
		}

		for(Animal an : al){
			System.out.print(an.getClass().getSimpleName() + ": ");
			an.makeNoise();
		}
	}
}
