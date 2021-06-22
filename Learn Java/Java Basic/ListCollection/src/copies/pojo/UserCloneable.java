package copies.pojo;


public class UserCloneable implements Cloneable{
	
	private Integer in;
	private String name;
	private AddressCloneable address;
	
	/**
	 * @return the in
	 */
	public Integer getIn() {
		return in;
	}
	/**
	 * @param in the in to set
	 */
	public void setIn(Integer in) {
		this.in = in;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public AddressCloneable getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressCloneable address) {
		this.address = address;
	}
	
	@Override
	public UserCloneable clone(){
		UserCloneable use;
		try {
			use = (UserCloneable) super.clone();
		}catch (CloneNotSupportedException e) {
			use = new UserCloneable();
			use.setIn(this.getIn());
			use.setName(this.getName());
		}
		use.setAddress(this.getAddress().clone()); //here code to clone address 
		return use;
	}
	@Override
	public String toString() {
		return "UserCloneable [in=" + in + ", name=" + name + ", address=" + address + "]";
	}
	
	
}