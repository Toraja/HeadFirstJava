import java.util.ArrayList;

public class FunWithConstructor {
	public static void main(String[] args){
		
		String dadName = "Joseph";
		String mumName = "Monica";
		String childName = "Nicole";
		
		Dad dad = new Dad(dadName);
		Mum mum = new Mum(mumName);
		
		Parents parents = dad.getMarriedWith(mum);
		Child child = parents.haveBaby(childName, "male");
		
		ArrayList<String> story = new ArrayList<String>();
		String line;
		
		line = "There was a dad, whose name was " + parents.getDad().getName() + "."; 
		story.add(line);
		
		line = "There was a mum, whose name was " + parents.getMum().getName() + ".";
		story.add(line);
		
		// get child's num
		line = "They had ";
		int numOfChildren = parents.getNumOfChildren();
		String childWordForm = "";
		line += String.valueOf(numOfChildren);
		if(numOfChildren > 1){
			childWordForm = " children.";
		} else{
			childWordForm = " child.";
		}
		line += childWordForm;
		story.add(line);
		
		if(numOfChildren > 0){
		line = "";
		String subject = "";
		String possessive = "";
		String male = "male";
		String female = "female";
		// compare child's DNA and display his/her name
			for(Child eachChild : parents.children){
				if(male.equals(eachChild.getSex())){
					subject = "he";
					possessive = "his";
				}
				else if(male.equals(eachChild.getSex())){
					subject = "she";
					possessive = "her";
				}
				else {
					subject = "he (or she?)";
				}
				String theChildName = eachChild.getName();
				line = "Is " + subject + " our child? " + eachChild.equals(child) + ", " + possessive + " name is " + theChildName;
				story.add(line);
				
				line = "Hey " + theChildName + ", what's your dad's name? " + eachChild.getParents().getDad().getName();
				story.add(line);
				
				line = "And what's your mum's name? " + eachChild.getParents().getMum().getName();
				story.add(line);
			}
		
		readStory(story);
		}
		else {
			line = "End of the story";
			story.add(line);
			readStory(story);
		}
	}
	
	public static void readStory(ArrayList<String> lines){
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
	
	public Child haveBaby(String name, String sex){
		Child child = new Child(this, name, sex);
		children.add(child);
		numOfChildren++;
		return child;
	}

}

class Child {

	String name;
	String sex;
	Parents parents;
	
	public Child(Parents parents, String name, String sex){
		this.parents = parents;
		this.name = name;
		this.sex = sex;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}	
	
	public void setParents(Parents parents){
		this.parents = parents;
	}
	public Parents getParents(){
		return this.parents;
	}

}
