package relativeentity.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address1")
public class C1Address {

	@Id
	@Column(name = "id")
	private Integer idxxxx;
	
	@Column(name = "strees")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	
	@OneToOne(mappedBy = "addressdb") // tên này trên Entity C1User1 có attribute C1Address addressdb
	private C1User user;


	/**
	 * @return the idxxxx
	 */
	public Integer getIdxxxx() {
		return idxxxx;
	}


	/**
	 * @param idxxxx the idxxxx to set
	 */
	public void setIdxxxx(Integer idxxxx) {
		this.idxxxx = idxxxx;
	}


	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}


	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the user
	 */
	public C1User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(C1User user) {
		this.user = user;
	}


	public C1Address() {
		super();
	}


	@Override
	public String toString() {
		return "C1Address [id=" + idxxxx + ", street=" + street + ", city=" + city + "]";
	}


	
}
