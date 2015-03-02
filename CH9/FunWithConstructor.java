import java.util.ArrayList;

public class FunWithConstructor {
	public static void main(String[] args){
		
		String dadName = "Joseph";
		String mumName = "Monica";
		String childName = "Nicole";
		
		Dad dad = new Dad(dadName);
		Mum mum = new Mum(mumName);
		
		Parents parents = dad.getMarriedWith(mum);
		Child child = parents.haveBaby(childName);
		
		String line1 = "There was a dad, whose name was " + parents.getDad().getName(); 
		String line2 = "There was a mum, whose name was " + parents.getMum().getName(); 
		
		// get child's num
		// get child's name from ArrayList
		// get child's parents DNA via direct reference
		// get child's parents DNA via child's instance variable
		// match those DNA
		
		String ending = "End of the story";
		
		buildStory(line1, line2, ending);
	}
	
	public static void buildStory(String... lines){
		for(String line : lines){
			System.out.println(line);
		}
	}
}

class Dad {
	String name;
	
	public Dad(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public Parents getMarriedWith(Mum mum){
		return new Parents(this, mum);
	}
}

class Mum {
	String name;
	
	public Mum(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public Parents getMarriedWith(Dad dad){
		return new Parents(dad, this);
	}
}


class Parents {
	
	Dad dad;
	Mum mum;
	int numOfChildren = 0;
	ArrayList<Child> children = new ArrayList<Child>();
	
	public Parents(Dad dad, Mum mum){
		this.dad = dad;
		this.mum = mum;
	}
	
	public void setDad(Dad dad){
		this.dad = dad;
	}
	public Dad getDad(){
		return this.dad;
	}

	public void setMum(Mum mum){
		this.mum = mum;
	}
	public Mum getMum(){
		return this.mum;
	}

	public void setNumOfChildren(int numOfChildren){
		this.numOfChildren = numOfChildren;
	}
	public int getNumOfChildren(){
		return this.numOfChildren;
	}
	
	public void setChildren(Child children){
		this.children.add(children);
	}
	public Child getChildren(int index){
		return this.children.get(index);
	}
	
	public Child haveBaby(String name){
		Child child = new Child(this, name);
		children.add(child);
		numOfChildren++;
		return child;
	}

}

class Child {

	String name;
	Parents parents;
	
	public Child(Parents parents, String name){
		this.parents = parents;
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setParents(Parents parents){
		this.parents = parents;
	}
	public Parents getParents(){
		return this.parents;
	}

}