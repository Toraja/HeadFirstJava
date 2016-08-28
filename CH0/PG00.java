public class PG00 {

	public static void main(String[] whatever) {
		// TODO Auto-generated method stub
		System.out.println("This works!! The name of the arguments does NOT have to be \"args\".");
		if(whatever == null){
			System.out.println("The argument of main method is null");
		}
		else {
			System.out.print("The argument of main method is NOT null");
			if(whatever.length > 0){
				System.out.println();
				System.out.println("The length of the argument is " + whatever.length);
				for (int i = 0; i < whatever.length; i ++){
					System.out.println(whatever[i]);
				}
			}
			else{
				System.out.println(", BUT empty.");
			}
		}
	}

}
