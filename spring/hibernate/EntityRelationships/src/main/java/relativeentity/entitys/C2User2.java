package relativeentity.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user2")
public class C2User2 {
	
	@Id
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinTable( // chỉ định bản trung gian làm join giá trị sẽ không null khác vs 2 cách onetoone còn lại
			name = "user2_add2",  // đang lấy User2 join với bản trung giang
			// joinColumns
			// lấy user_id của bảng trung giang join với Id của User2 này
			joinColumns = {@JoinColumn(columnDefinition = "user_id", referencedColumnName = "id")}
			
			,inverseJoinColumns = {@JoinColumn(columnDefinition = "address_id", referencedColumnName = "id")}) 
			// inverseJoinColumns tiếp tục lấy attribute address_id join vơi id của Address.
	
	private C2Address2 address;
	
	public C2User2() {
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
	 * @return the address2
	 */
	public C2Address2 getAddress() {
		return address;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress(C2Address2 address2) {
		this.address = address2;
	}

	@Override
	public String toString() {
		return "C2User2 [id=" + id + ", username=" + username + ", address2=" + address.toString() + "]";
	}

	 

	 
}
