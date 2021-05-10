package java11feature.methodsnew.classes;

public class NetstedAndOuterClass {

	private A_Level1 a_Level1;
	
	NetstedAndOuterClass(){
		a_Level1 = new A_Level1();
	}
	
	// java 11 support class netsted access private field of class outer
	private String propertiesOuter = " NetstedAndOuterClass ";

	private void methodOuter() {
		System.out.println(" NetstedAndOuterClass "+ propertiesOuter);
	}

	class A_Level1 {
		
		private A_Level2 a_Level2;
		
		A_Level1(){
			a_Level2 = new A_Level2();
		}
		
		private String propertiesA_Level1 = " A_Level1";
		private void method_A_Level1() {
			// java 11 use properties private of outer class
			System.out.println("method_A_Level1 " + propertiesOuter + propertiesA_Level1);
		}

		
		class A_Level2 {
			private String propertiesA_Level2 = " A_Level2 ";
			private void method_A_Level2() {
				// java 11 use properties private of outer class
				System.out.println("A_Level2 calling " + NetstedAndOuterClass.this.propertiesOuter  
						+ A_Level1.this.propertiesA_Level1  + propertiesA_Level2);
			}
		}
	}
	
	public static void main(String[] args) {
		 
		NetstedAndOuterClass netstedAndOuterClass = new NetstedAndOuterClass();
		netstedAndOuterClass.a_Level1.a_Level2.method_A_Level2();
	}
	
}