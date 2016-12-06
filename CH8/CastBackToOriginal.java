/**
 * Cast method of Class class is useless?
 * It is impossible to assign the returned object to a variable of the type
 * if the Class object which the cast method is called on is a variable and 
 * the compiler cannot know actual type of the class.
 * SomeClass sc = (new SomeClass).getClass().cast(obj); is valid though
 */
public class CastBackToOriginal{
	public static void main(String[] args){
		Metal[] metalArray = {new Gold(), new Iron(), new Mercury()};

		for(Metal metal : metalArray){
			Class theClass = metal.getClass();
			System.out.println(theClass.getName());
			System.out.println(theClass.cast(metal).getClass().getName());
			// commented lines below are illegal
			if(metal instanceof Gold){
				// Gold g = theClass.cast(metal);
				// Gold g = (new Gold()).getClass().cast(metal);
				// g.shine();
				(new Gold()).getClass().cast(metal).shine();
			}
			else if(metal instanceof Iron){
				// Iron i = theClass.cast(metal);
				// i.rust();
				(new Iron()).getClass().cast(metal).rust();
			}
			else if(metal instanceof Mercury){
				// Mercury m = theClass.cast(metal);
				// m.flow();
				(new Mercury()).getClass().cast(metal).flow();
			}
		}
	}
}

abstract class Metal{
}

class Gold extends Metal{
	void shine(){
		System.out.println("Bling Bling");
	}
}

class Iron extends Metal{
	void rust(){
		System.out.println("I used to shine like that too...");
	}
}

class Mercury extends Metal{
	void flow(){
		System.out.println("flowing like water");
	}
}
