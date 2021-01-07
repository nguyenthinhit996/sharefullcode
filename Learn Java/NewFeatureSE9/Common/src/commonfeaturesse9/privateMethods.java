package commonfeaturesse9;

public interface privateMethods {
	
	void abstractFunction();
	
	default void defaultFunction() {
		privateFunction();
	}
	
	default void defaultFunction2() {
		privateFunction();
	}
	
	// private method for share common source between defautl methods.
	private void privateFunction() {
		System.out.println("hixxxxxx");
	}
}
