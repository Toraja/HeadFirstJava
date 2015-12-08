public class AnimalArray{
	Animal[] animarray = new Animal[5];
	int nextIndex = 0;

	void add(Animal a){
		if(nextIndex < animarray.length){
			animarray[nextIndex] = a;
			nextIndex++;
		}
	}

	public static void main(String[] args){
		AnimalArray animarray = new AnimalArray();
		Animal ani;
		Class aniCls;
		String aniClsName;
		Class dogCls = Dog.class;
		Class catCls = Cat.class;
		Cat c;

		for(int i = 0; i < animarray.animarray.length; i++){
			if((i % 2) == 0){
				ani = new Dog();
			}
			else {
				ani = new Cat();
			}
			animarray.add(ani);
		}

		for(Animal an : animarray.animarray){
			aniCls = an.getClass();
			aniClsName = aniCls.getName();
			System.out.print(aniClsName + " is making noise: ");
			an.makeNoise();

			if(aniCls == dogCls){
				System.out.println(aniClsName + " can do nothing else");
			}
			else if(aniCls == catCls){
				//c = an.getClass().cast(an);
				c = Cat.class.cast(an);
				//c = (Cat)an;
				System.out.print(aniClsName + " can catwalk too: ");
				c.catwalk();
			}

			//switch(aniCls){
				//case Dog.class:
					//System.out.println(aniClsName + " can do nothing else");
					//break;
				//case catCls:
					//c = an.getClass().cast(an);
					//System.out.print(aniClsName + " can catwalk too: ");
					//break;
				//default:
					//break;
			//}
		}
	}
}
