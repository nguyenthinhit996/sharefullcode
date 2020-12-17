package featuresameple.lambda;

public class Lambdasample {

	private static int percent = 100;
	static int a;
	int aa;
	
	void test() {
		
		int localVariable=100;
		
		// lambda in SE8 or later version
		Functionlambdatest se8 = (percent) -> {
			a=a+100;
			aa=111;
			aa=aa+localVariable;
			return percent == 100 ? true : false;
		};
 
		boolean stateSe7=se8.test(222);
		System.out.println("Result test: "+stateSe7);
	}

	public static void main(String[] args) {

		// function in SE7 or earlier version
		Functionlambdatest se7 = new Functionlambdatest() {
			@Override
			public boolean test(int percent) {
				return percent == 100 ? true : false;
			}

		};
	
		Lambdasample a= new Lambdasample();
		a.test();
	
		boolean stateSe7=se7.test(percent);
	 
		
		System.out.println("Result se7: "+stateSe7);
		 
	}
}

interface Functionlambdatest {
	public boolean test(int percent);
}