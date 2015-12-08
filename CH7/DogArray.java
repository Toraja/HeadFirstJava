public class DogArray {
	Dog[] dogs = new Dog[5];
	int nextIndex = 0;

	DogArray(){
		//this.dogs = new Dog[5];
	}
	void add(){
		if(nextIndex < dogs.length){
			dogs[nextIndex] = new Dog();
			nextIndex++;
		}
	}
	
	public static void main(String[] args) {
		DogArray darr = new DogArray();
		for(int i = 0; i < 8; i++){
			darr.add();
		}

		for(int i = 0; i < darr.nextIndex; i++){
			darr.dogs[i].makeNoise();
		}
	}

}

