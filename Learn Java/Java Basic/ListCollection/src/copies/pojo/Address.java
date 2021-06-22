package copies.pojo;

import java.io.Serializable;

/**
 * use implements Serializable with Apache Commons Lang SerializationUtils.clone(object);
 * @author Peter
 *
 */
public class Address implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -6421397813540335050L;
	private String TP;

	/**
	 * @return the tP
	 */
	public String getTP() {
		return TP;
	}

	/**
	 * @param tP the tP to set
	 */
	public void setTP(String tP) {
		TP = tP;
	}

	@Override
	public String toString() {
		return "Address [TP=" + TP + "]";
	}
	
	
}
