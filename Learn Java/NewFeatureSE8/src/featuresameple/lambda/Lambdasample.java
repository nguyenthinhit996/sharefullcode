package featuresameple.lambda;

public class Lambdasample {

	// Golbal static variable
	static int golbalStaticVariable=444;
	// Golbal variable 
	private int golbalVarable=88;

	
	
	void test() {
		// local variabe
		int localVariable=100;
		
		// lambda in SE8 or later version
		Functionlambdatest se8 = () -> {
			golbalStaticVariable=golbalStaticVariable+100;
			golbalVarable=111;
			golbalVarable=golbalVarable+localVariable;	
			return golbalStaticVariable == 100 ? true : false;
		};
		
		 
		boolean stateSe7=se8.test();
		System.out.println("Result se8: "+stateSe7);
	}

	public static void main(String[] args) {

		// function in SE7 or earlier version
		Functionlambdatest se7 = new Functionlambdatest() {
			@Override
			public boolean test() {
				return golbalStaticVariable == 100 ? true : false;
			}

		};
	
		Lambdasample a= new Lambdasample();
		a.test();
	
		boolean stateSe7=se7.test();
	 
		
		System.out.println("Result se7: "+stateSe7);
		 
	}
}

interface Functionlambdatest {
	public boolean test();
}