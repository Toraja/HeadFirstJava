// helloooo... 
// helloooo... 
// helloooo... 
// helloooo... 
// 10

public class EchoTestDrive24{
	public static void main(String[] args){
		Echo24 e1 = new Echo24();
		Echo24 e2 = e1;
		int x = 0;
		while(x < 4){
			e1.hello();
			e1.count = e1.count + 1;
			if(x > 0){
				e2.count = e2.count + 1;
			}
			if(x > 1){
				e2.count = e2.count + e1.count;
			}
			x = x + 1;
		}
		System.out.println(e2.count);
	}
}

class Echo24{
	int count = 0;
	void hello(){
		System.out.println("helloooo... ");
	}
}