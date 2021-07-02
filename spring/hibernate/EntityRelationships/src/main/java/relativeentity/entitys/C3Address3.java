package relativeentity.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address3")
public class C3Address3 {

	@Id
	@Column(name = "id_user")
	private Integer idxxxx;
	
	@Column(name = "strees")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	
	@OneToOne
	@MapsId // nó sẽ copy primaryKey của User3 đến @JoinColumn user_id vừa là khóa chính vừa là khóa ngoại của C3Address3
	@JoinColumn(name = "id_user")
	private C3User3 user;


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
	public C3User3 getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(C3User3 user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "C3Address3 [idxxxx=" + idxxxx + ", street=" + street + ", city=" + city + "]";
	}
}
