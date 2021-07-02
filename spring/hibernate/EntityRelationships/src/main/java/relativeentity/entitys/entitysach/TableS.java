package relativeentity.entitys.entitysach;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tables")
public class TableS {
	
	@Id
	@Column(name = "d") // là cột D trong sách
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "tabler_id") // trong sách là cột C
	private TableR idTableR;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the idTableR
	 */
	public TableR getIdTableR() {
		return idTableR;
	}

	/**
	 * @param idTableR the idTableR to set
	 */
	public void setIdTableR(TableR idTableR) {
		this.idTableR = idTableR;
	}

	public TableS() {
		super();
	}

	@Override
	public String toString() {
		return "TableS [id=" + id +"]";
	}
	
	
}
