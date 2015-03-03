import java.util.ArrayList;

public class FunWithConstructor {
	public static void main(String[] args){
		
		String dadName = "Joseph";
		String mumName = "Monica";
		
		Story story1 = new Story();
		
		try{
			story1.makeStory(4, dadName, mumName);
			story1.readStory();
		}
		catch(Exception e){
			// do nothing
		}
	}
	
	
}

class Commons {
	static String MALE = "male";
	static String FEMALE = "female";
	// static enum SEX {MALE, FEMALE};
	
	static int CHILD_NUM_LIMIT = 5;
}

class Story {
	
	ArrayList<String> story = new ArrayList<String>();
	
	public void makeStory(int numOfChildren, String dadName, String mumName) throws Exception {
		if(numOfChildren > Commons.CHILD_NUM_LIMIT){
			System.out.println("Have you been using condom? You are having too many children!");
			throw new Exception();
		}
		
		Dad dad = new Dad(dadName);
		Mum mum = new Mum(mumName);
		
		Parents parents = dad.getMarriedWith(mum);
		
		for(int i = 0; i < numOfChildren; i++){
			parents.haveBaby();
		}
		
		String line;
		
		line = "There was a dad, whose name was " + parents.getDad().getName(); 
		story.add(line);
		
		line = "There was a mum, whose name was " + parents.getMum().getName();
		story.add(line);
		
		// get child's num
		String childWordForm = "";

		if(numOfChildren > 1){
			childWordForm = " children";
		} else{
			childWordForm = " child";
		}
		line = "They had " + String.valueOf(numOfChildren) + childWordForm;
		story.add(line);
		
		if(numOfChildren > 0){
		int counter = 0;
		// compare child's DNA and display his/her name
			for(Child eachChild : parents.getAllChildren()){
				counter++;
				String ordinalNum = "";
				
				switch(counter){
				case 1:
					ordinalNum = "1st";
					break;
				case 2:
					ordinalNum = "2nd";
					break;
				case 3:
					ordinalNum = "3rd";
					break;
				default:
					ordinalNum = counter + "th";
					break;
				}
				String childName = eachChild.getName();
				line = "The name of the " + ordinalNum + " child was " + childName;
				story.add(line);
				
				line = "Hey " + childName + ", what's your dad's name? " + eachChild.getParents().getDad().getName();
				story.add(line);
				
				line = "And what's your mum's name? " + eachChild.getParents().getMum().getName();
				story.add(line);
			}
			
		line = "The family lived happily";
		story.add(line);
		}
		else {
			line = "They enjoyed their life";
			story.add(line);
		}
	}
	
	public void readStory(){
		for(String line : story){
			System.out.println(line + ".");
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
	
	String[] maleNameList = {"Nicole", "Stephane", "Andrew", "Guy", "Richard"};
	String[] femaleNameList = {"Sophia", "Victor", "Cathy", "Becky", "Diana"};
	String[] unisexNameList = {"", "", "", "", ""};
		
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
	public ArrayList<Child> getAllChildren(){
		return this.children;
	}
	
	public void haveBaby(){
		String sex = determineSex();
		String name = chooseChildName(sex);
		Child child = new Child(this, name, sex);
		children.add(child);
		numOfChildren++;
	}
	
	public String determineSex(){
		String sex = "";
		if((int)(Math.random() * 2) == 0){
			sex = Commons.MALE;
		}
		else {
			sex = Commons.FEMALE;
		}
		
		return sex;
	} 
	
	public String chooseChildName(String sex){
		String name;
		
		if(sex.equals(Commons.MALE)){
			name = maleNameList[numOfChildren];
		}
		else if(sex.equals(Commons.FEMALE)){
			name = femaleNameList[numOfChildren];
		}
		else {
			name = unisexNameList[numOfChildren];
		}
		
		return name;
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
