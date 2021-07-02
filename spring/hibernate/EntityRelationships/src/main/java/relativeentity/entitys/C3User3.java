package relativeentity.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user3")
public class C3User3 {
	
	@Id
	private Integer id;
	
	@Column(name = "name")
	private String username;
	
	@OneToOne(cascade =CascadeType.ALL)
	@PrimaryKeyJoinColumn // chỉ định rằng primary key của bảng này được sử dụng như là khóa ngoại của bản Address
	private C3Address3 addressdb;
	
	public C3User3() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the addressdb
	 */
	public C3Address3 getAddressdb() {
		return addressdb;
	}

	/**
	 * @param addressdb the addressdb to set
	 */
	public void setAddressdb(C3Address3 addressdb) {
		this.addressdb = addressdb;
	}

	@Override
	public String toString() {
		return "C3User3 [id=" + id + ", username=" + username + ", addressdb=" + addressdb + "]";
	}

	
	 
}
