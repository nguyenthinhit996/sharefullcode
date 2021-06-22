package copies.pojo;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

/**
 * use implements Serializable with Apache Commons Lang SerializationUtils.clone(object);
 * @author Peter
 *
 */
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4409718032151921780L;
	private Integer in;
	private String name;
	private Address address;
	
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
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [in=" + in + ", name=" + name + ", address=" + address + "]";
	}
	public User(Integer in, String name, Address address) {
		super();
		this.in = in;
		this.name = name;
		this.address = address;
	}
	public User() {
		super();
	}
	
	/**
	 * use for method copyDeepListToList 
	 * @param User
	 */
	public User(User user) {
		 this.name = user.getName();
		 this.in = user.getIn();
		 this.address = SerializationUtils.clone(user.getAddress());
	}
}
