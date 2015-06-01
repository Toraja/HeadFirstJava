import java.util.HashMap;

public class EntrySet{
	public static void main (String[] args){
		HashMap<Integer, PG00> hmap = new HashMap<Integer, PG00>();
		for(int i = 0; i < 4; i++){
			hmap.put(i, new PG00());
		}
		System.out.println(hmap.entrySet());
	}
}
