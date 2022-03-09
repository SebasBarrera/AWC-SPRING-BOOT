package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the productproductphoto database table.
 * 
 */
@Embeddable
public class ProductproductphotoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer productid;

	@Column(insertable=false, updatable=false)
	private Integer productphotoid;

	public ProductproductphotoPK() {
	}
	public Integer getProductid() {
		return this.productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getProductphotoid() {
		return this.productphotoid;
	}
	public void setProductphotoid(Integer productphotoid) {
		this.productphotoid = productphotoid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductproductphotoPK)) {
			return false;
		}
		ProductproductphotoPK castOther = (ProductproductphotoPK)other;
		return 
			this.productid.equals(castOther.productid)
			&& this.productphotoid.equals(castOther.productphotoid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productid.hashCode();
		hash = hash * prime + this.productphotoid.hashCode();
		
		return hash;
	}
}