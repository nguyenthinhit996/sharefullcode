//package relativeentity.entitys;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "user2_add2")
//public class User_Add {
//	
//	@Id
//	@Column(name="idmid")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	
//	@OneToOne
//	@JoinColumn(columnDefinition = "user_id", referencedColumnName = "id")
//	private C2User2 user;
//	
//	@OneToOne
//	@JoinColumn(columnDefinition = "address_id", referencedColumnName = "id")
//	private C2Address2 address;
//
//	/**
//	 * @return the id
//	 */
//	public Integer getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	/**
//	 * @return the user
//	 */
//	public C2User2 getUser() {
//		return user;
//	}
//
//	/**
//	 * @param user the user to set
//	 */
//	public void setUser(C2User2 user) {
//		this.user = user;
//	}
//
//	/**
//	 * @return the address
//	 */
//	public C2Address2 getAddress() {
//		return address;
//	}
//
//	/**
//	 * @param address the address to set
//	 */
//	public void setAddress(C2Address2 address) {
//		this.address = address;
//	}
//
//	public User_Add() {
//		super();
//	}
//
//	   
//}
