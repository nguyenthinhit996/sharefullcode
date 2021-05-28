package relativeentity.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users1")
public class C1User {
	
	@Id
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@OneToOne(cascade =CascadeType.ALL)
	// @JoinColumn
	// sử dụng column name ở dưới DB ko phải Entity
	// lấy attribute addressdb_id này reference đến id của table address1
	@JoinColumn(columnDefinition = "addressdb_id", referencedColumnName = "id") 	
	private C1Address addressdb;// tên addressdb + _id phải lưu vào Database nếu ko lỗi.
	
	public C1User() {
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
	public C1Address getAddressdb() {
		return addressdb;
	}

	/**
	 * @param addressdb the addressdb to set
	 */
	public void setAddressdb(C1Address addressdb) {
		this.addressdb = addressdb;
	}

	@Override
	public String toString() {
		return "C1User [id=" + id + ", username=" + username + ", addressdb=" + addressdb.toString() + "]";
	}

	 
}
