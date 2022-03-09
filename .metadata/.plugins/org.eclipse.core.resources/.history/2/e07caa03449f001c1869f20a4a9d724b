package co.edu.icesi.dev.uccareapp.transport.model.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the specialofferproduct database table.
 * 
 */
@Embeddable
public class SpecialofferproductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer specialofferid;

	@Column(insertable=false, updatable=false)
	private Integer productid;

	public SpecialofferproductPK() {
	}
	public Integer getSpecialofferid() {
		return this.specialofferid;
	}
	public void setSpecialofferid(Integer specialofferid) {
		this.specialofferid = specialofferid;
	}
	public Integer getProductid() {
		return this.productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SpecialofferproductPK)) {
			return false;
		}
		SpecialofferproductPK castOther = (SpecialofferproductPK)other;
		return 
			this.specialofferid.equals(castOther.specialofferid)
			&& this.productid.equals(castOther.productid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.specialofferid.hashCode();
		hash = hash * prime + this.productid.hashCode();
		
		return hash;
	}
}