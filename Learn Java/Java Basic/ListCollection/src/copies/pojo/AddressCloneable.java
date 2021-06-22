package copies.pojo;


public class AddressCloneable implements Cloneable{
	
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
	public AddressCloneable clone(){
		AddressCloneable address;
		try {
			address = (AddressCloneable) super.clone();
		}
		catch(CloneNotSupportedException e) {
			address = new AddressCloneable();
			address.setTP(this.getTP());
		}
		return address;
	}

	@Override
	public String toString() {
		return "AddressCloneable [TP=" + TP + "]";
	}
	
}
