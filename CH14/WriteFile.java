import java.io.FileWriter;
import java.io.IOException;

public class WriteFile{
	public static void main(String[] args){
		try{
			FileWriter writer = new FileWriter("Foo.txt");
			writer.write("hello foo!\n");
			writer.write("how are you, sir?\n");
			writer.write("bye bar!");
			writer.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
