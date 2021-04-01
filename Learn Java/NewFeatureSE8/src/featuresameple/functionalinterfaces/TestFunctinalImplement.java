package featuresameple.functionalinterfaces;
 

public class TestFunctinalImplement implements TestFunctinal, TestFunctinal2{

	@Override
	public Integer methodAbstractPow2(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer methodAbstractPow(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void methodDefault3() {
		System.out.println("methodDefault3 @Override");
	}

	@Override
	public void methodDefault1() {
		// TODO Auto-generated method stub
		TestFunctinal2.super.methodDefault1();
	}

	@Override
	public void methodDefault2() {
		// TODO Auto-generated method stub
		TestFunctinal.super.methodDefault2();
	}
	
	public static void main(String[] args) {
		
		TestFunctinalImplement testFunctinalImplement = new TestFunctinalImplement();
		testFunctinalImplement.methodDefault3();
	}
	 
}
