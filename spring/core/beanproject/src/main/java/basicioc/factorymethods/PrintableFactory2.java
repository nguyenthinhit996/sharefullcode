package basicioc.factorymethods;

public class PrintableFactory2 {

//	type2 funtion static
	public static Printable getInstance() {
		return new AimplPrintable();
	}
}
