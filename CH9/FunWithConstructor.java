import java.util.ArrayList;

public class FunWithConstructor {
	public static void main(String[] args){

		String dadName = "Joseph";
		String mumName = "Monica";

		Story story0 = new Story();
		Story story1 = new Story();
		Story story2 = new Story();

		try{
			story0.writeStory(0, "David", "Stacy");
			story0.readStory();

			story1.writeStory(4, dadName, mumName);
			story1.readStory();

			story2.writeStory(6, "Vincent", "Alice");
			story2.readStory();
		}
		catch(Exception e){
			// do nothing
		}
	}

}

enum Sex {
	MALE("male"), FEMALE("female");

	String string;
	Sex(String s){
		string = s;
	}
	public String getLiteral(){
		return string;
	}
}

class TooManyChildException extends Exception {
}

class Story {
	static int CHILD_NUM_LIMIT = 5;

	ArrayList<Line> story = new ArrayList<Line>();

	public enum EndPunc {
		PERIOD("."), QUESTION("?"), NONE("");

		String string;
		EndPunc(String s){
			string = s;
		}
		public String getLiteral(){
			return string;
		}
	}

	public void writeStory(int numOfChildren, String dadName, String mumName) throws TooManyChildException {
		if(numOfChildren > CHILD_NUM_LIMIT){
			System.out.println("You have " + numOfChildren + " kids!?");
			System.out.println("Do you know what condom is? You are having too many children!");
			throw new TooManyChildException();
		}

		Dad dad = new Dad(dadName);
		Mum mum = new Mum(mumName);

		Parents parents = dad.getMarriedWith(mum);

		for(int i = 0; i < numOfChildren; i++){
			parents.haveBaby();
		}

		String line;

		// Chapter 1
		line = "There was a dad, whose name was " + parents.getDad().getName();
		story.add(new Statement(line));
		line = "There was a mum, whose name was " + parents.getMum().getName();
		story.add(new Statement(line));
		story.add(new Blank());

		// Chapter 2
		// inform the number of children the parents had
		String childWordForm = "";
		if(numOfChildren > 1){
			childWordForm = " children";
		} else{
			childWordForm = " child";
		}

		line = "They had " + String.valueOf(numOfChildren) + childWordForm;
		story.add(new Statement(line));
		story.add(new Blank());

		if(numOfChildren > 0){
		int counter = 0;
		// ask children about their parents name
			for(Child eachChild : parents.getChildren()){
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
				story.add(new Statement(line));

				line = "Hey " + childName + ", what's your dad's name";
				story.add(new Question(line));
				line = eachChild.getParents().getDad().getName();
				story.add(new Statement(line));

				line = "And what's your mum's name";
				story.add(new Question(line));
				line = eachChild.getParents().getMum().getName();
				story.add(new Statement(line));
				story.add(new Blank());
			}

		// Ending
		line = "The family lived happily";
		story.add(new Statement(line));
		}
		else {
			// Ending
			line = "They enjoyed their life";
			story.add(new Statement(line));
		}
	}

	public void readStory(){
		for(Line line : story){
			System.out.print(line.getContents());
			System.out.println(line.getEndPunc().getLiteral());
		}
		System.out.println(System.lineSeparator());
	}

	abstract class Line {
		String contents;
		EndPunc endPunc;

		public void setContents(String contents){
			this.contents = contents;
		}
		public String getContents(){
			return this.contents;
		}

		public void setEndPunc(EndPunc endPunc){
			this.endPunc = endPunc;
		}
		public EndPunc getEndPunc(){
			return this.endPunc;
		}
	}

	class Statement extends Line{
		public Statement(String contents){
			this.contents = contents;
			this.endPunc = EndPunc.PERIOD;
		}
	}
	class Question extends Line{
		public Question(String contents){
			this.contents = contents;
			this.endPunc = EndPunc.QUESTION;
		}
	}
	class Blank extends Line{
		public Blank(){
			this.endPunc = EndPunc.NONE;
			this.contents = "";
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

	public void addChild(Child children){
		this.children.add(children);
	}
	public Child getChild(int index){
		return this.children.get(index);
	}
	public ArrayList<Child> getChildren(){
		return this.children;
	}

	public void haveBaby(){
		Sex sex = determineSex();
		String name = chooseChildName(sex);
		Child child = new Child(this, name, sex);
		children.add(child);
	}

	public Sex determineSex(){
		Sex sex;
		if((int)(Math.random() * 2) == 0){
			sex = Sex.MALE;
		}
		else {
			sex = Sex.FEMALE;
		}

		return sex;
	}

	public String chooseChildName(Sex sex){
		String name;

		if(sex.equals(Sex.MALE)){
			name = maleNameList[this.children.size()];
		}
		else if(sex.equals(Sex.FEMALE)){
			name = femaleNameList[this.children.size()];
		}
		else {
			name = unisexNameList[this.children.size()];
		}

		return name;
	}

}

class Child {

	String name;
	Sex sex;
	Parents parents;

	public Child(Parents parents, String name, Sex sex){
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

	public void setSex(Sex sex){
		this.sex = sex;
	}
	public Sex getSex(){
		return this.sex;
	}

	public void setParents(Parents parents){
		this.parents = parents;
	}
	public Parents getParents(){
		return this.parents;
	}

}
