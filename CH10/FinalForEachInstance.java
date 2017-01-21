public class FinalForEachInstance{
	final int finalInt;

	FinalForEachInstance(int i){
		finalInt = i;
	}

	public static void main(String[] args){
		FinalForEachInstance ffei = new FinalForEachInstance(3);
		System.out.println(ffei.finalInt);
	}
}
