package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the workorderrouting database table.
 * 
 */
@Embeddable
public class WorkorderroutingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer workorderid;

	private Integer productid;

	private Integer operationsequence;

	public WorkorderroutingPK() {
	}
	public Integer getWorkorderid() {
		return this.workorderid;
	}
	public void setWorkorderid(Integer workorderid) {
		this.workorderid = workorderid;
	}
	public Integer getProductid() {
		return this.productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getOperationsequence() {
		return this.operationsequence;
	}
	public void setOperationsequence(Integer operationsequence) {
		this.operationsequence = operationsequence;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkorderroutingPK)) {
			return false;
		}
		WorkorderroutingPK castOther = (WorkorderroutingPK)other;
		return 
			this.workorderid.equals(castOther.workorderid)
			&& this.productid.equals(castOther.productid)
			&& this.operationsequence.equals(castOther.operationsequence);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.workorderid.hashCode();
		hash = hash * prime + this.productid.hashCode();
		hash = hash * prime + this.operationsequence.hashCode();
		
		return hash;
	}
}