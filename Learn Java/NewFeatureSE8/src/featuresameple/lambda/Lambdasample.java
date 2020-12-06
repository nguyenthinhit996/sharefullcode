package featuresameple.lambda;

public class Lambdasample {

	private static int percent = 100;

	public static void main(String[] args) {

		// function in SE7 or earlier version
		Functionlambdatest se7 = new Functionlambdatest() {
			@Override
			public boolean test(int percent) {
				return percent == 100 ? true : false;
			}

		};

		// lambda in SE8 or later version
		Functionlambdatest se8 = (percent) -> {
			return percent == 100 ? true : false;
		};
		
		boolean stateSe7=se7.test(percent);
		boolean stateSe8=se8.test(percent);
		
		System.out.println("Result se7: "+stateSe7);
		System.out.println("Result se8: "+stateSe8);
	}
}

interface Functionlambdatest {
	public boolean test(int percent);
}