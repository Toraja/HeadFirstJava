import java.io.IOException;

public class ReturnThrowFinally{
	public static void main(String[] args) throws IOException{
		ReturnThrowFinally.callEx();
	}

	public static void throwEx() throws IOException{
		if((int)(Math.random() * 2) == 0){
			throw new IOException();
		}
	}

	public static void callEx() throws IOException{
		try{
			ReturnThrowFinally.throwEx();
			System.out.println("mid of try clause");
			return;
		}
		catch(IOException ioe){
			System.out.println("in the catch clause");
			throw ioe;
		}
		finally{
			System.out.println("finally!!");
		}

		// compiler complains that this is unreachable
		// System.out.println("end of callEx()");
	}
}
