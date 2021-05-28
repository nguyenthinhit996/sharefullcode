package relativeentity.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address2")
public class C2Address2 {

	@Id
	@Column(name = "id")
	private Integer idxxxx;
	
	@Column(name = "strees")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@OneToOne(mappedBy = "address")
	private C2User2 user;


	 


	public C2Address2() {
		super();
	}





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
	 * @return the user2
	 */
	public C2User2 getUser2() {
		return user;
	}





	/**
	 * @param user2 the user2 to set
	 */
	public void setUser2(C2User2 user2) {
		this.user = user2;
	}





	@Override
	public String toString() {
		return "C1Address [id=" + idxxxx + ", street=" + street + ", city=" + city + "]";
	}


	
}
