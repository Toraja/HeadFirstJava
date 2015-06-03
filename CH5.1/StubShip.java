import java.util.ArrayList;
import java.util.Arrays;

public class StubShip{
	//StubShip(){ // cannot access super() ...
	//    super(Ship.ShipSize.Mid, new ArrayList<String>());
	//}

	public static void main(String[] args){
		PlayField.Direction[] darray1 = {PlayField.Direction.Up};
		PlayField.Direction[] darray2 = {PlayField.Direction.Up};
		if(Arrays.equals(darray1, darray2)){
			System.out.println("They are same!");
		}else{
			System.out.println("They are different...");
		}
	}
}
