package relativeentity.entitys.entitysach;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tabler")
public class TableR {

	@Id
	@Column(name = "a") // là cột A Trong sách
	private Integer id;
	
	@Column(name = "b") // là Cột B Trong sách nè 
	private String columnB;
	
	@OneToMany(mappedBy = "idTableR")
	List<TableS> listTableS;

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
	 * @return the columnB
	 */
	public String getColumnB() {
		return columnB;
	}

	/**
	 * @param columnB the columnB to set
	 */
	public void setColumnB(String columnB) {
		this.columnB = columnB;
	}

	/**
	 * @return the listTableS
	 */
	public List<TableS> getListTableS() {
		return listTableS;
	}

	/**
	 * @param listTableS the listTableS to set
	 */
	public void setListTableS(List<TableS> listTableS) {
		this.listTableS = listTableS;
	}

	public TableR() {
		super();
	}

	@Override
	public String toString() {
		return "TableR [id=" + id + ", columnB=" + columnB + "]";
	}
	
	
	
}
