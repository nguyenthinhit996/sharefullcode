package featuresameple.lambda;

public class Lambdasample {

	// Golbal static variable
	static int golbalStaticVariable = 1; // change able in lambda
	// Golbal variable
	private int golbalVarable = 1; // change able in lambda


	void test() {
		// local variabe
		int localVariable = 1; // only use not change

		// lambda in SE8 or later version
		Functionlambdatest se8 = () -> {
			golbalStaticVariable = golbalStaticVariable + 100;
			System.out.println("In lambda golbalStaticVariable: "+golbalStaticVariable); //101
			golbalVarable = 100;
			golbalVarable = golbalVarable + localVariable;
			System.out.println("In lambda golbalVarable: "+golbalVarable); //101
			return golbalStaticVariable == 100 ? true : false;
		};

		boolean stateSe8 = se8.test();
		System.out.println("Result se8: " + stateSe8);
		System.out.println("Out lambda golbalStaticVariable: "+golbalStaticVariable); //101
		System.out.println("Out lambda golbalVarable: "+golbalVarable); //101
	}

	public static void main(String[] args) {

		// function in SE7 or earlier version
		Functionlambdatest se7 = new Functionlambdatest() {
			@Override
			public boolean test() {
				return golbalStaticVariable == 100 ? true : false;
			}

		};

		Lambdasample a = new Lambdasample();
		 
		a.test();

		boolean stateSe7 = se7.test();

		System.out.println("Result se7: " + stateSe7);

	}
}

interface Functionlambdatest {
	public boolean test();
}