package basicioc.beanannotations;

public class Pojobeanannotation {
	
	private int a;
	private String b;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	
	// use bean auto call default contructor
	public Pojobeanannotation() {
		this.a=0;
		this.b="Default contructor";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  this.a +","+ this.b;
	}
}
