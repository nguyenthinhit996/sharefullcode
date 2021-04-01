package featuresameple.annotations;

@authorclass(
		author = "John Doe", 
		date = "3/17/2002", 
		currentRevision = 6, 
		lastModified = "4/12/2004", 
		lastModifiedBy = "Jane Doe",
		// Note array notation
		reviewers = { "Alice", "Bob", "Cindy" }
		)
public class Annotationssample {
	 
	@UserAction(name="peter",day="2020/12/12")
	@UserAction(name="peter1",day="2020/12/12")
	@UserAction(name="peter2",day="2020/12/12")
	int coutdown() {
		//some code
		return 0;
	}
	public static void main(String[] args) {
		Annotationssample newob= new Annotationssample();
		System.out.println(newob.coutdown());
		
		 
	}
}
