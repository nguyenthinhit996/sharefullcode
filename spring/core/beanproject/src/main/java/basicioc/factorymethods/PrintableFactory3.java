package basicioc.factorymethods;

public class PrintableFactory3 {

	PrintableFactory3(){
		System.out.println("type3 funtion static get contruct default sau do call getInstance");
	}
	
	//type3 funtion static
	public Printable getInstance() {
		return new AimplPrintable();
	}
}
