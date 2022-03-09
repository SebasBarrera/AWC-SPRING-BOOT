package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the productdocument database table.
 * 
 */
@Embeddable
public class ProductdocumentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer productid;

	@Column(insertable=false, updatable=false)
	private String documentnode;

	public ProductdocumentPK() {
	}
	public Integer getProductid() {
		return this.productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getDocumentnode() {
		return this.documentnode;
	}
	public void setDocumentnode(String documentnode) {
		this.documentnode = documentnode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductdocumentPK)) {
			return false;
		}
		ProductdocumentPK castOther = (ProductdocumentPK)other;
		return 
			this.productid.equals(castOther.productid)
			&& this.documentnode.equals(castOther.documentnode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productid.hashCode();
		hash = hash * prime + this.documentnode.hashCode();
		
		return hash;
	}
}