package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the transactionhistoryarchive database table.
 * 
 */
@Entity
@NamedQuery(name="Transactionhistoryarchive.findAll", query="SELECT t FROM Transactionhistoryarchive t")
public class Transactionhistoryarchive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSACTIONHISTORYARCHIVE_TRANSACTIONID_GENERATOR",allocationSize = 1, sequenceName="TRANSACTIONHISTORYARCHIVE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSACTIONHISTORYARCHIVE_TRANSACTIONID_GENERATOR")
	private Integer transactionid;

	private BigDecimal actualcost;

	private Timestamp modifieddate;

	private Integer productid;

	private Integer quantity;

	private Integer referenceorderid;

	private Integer referenceorderlineid;

	private Timestamp transactiondate;

	private String transactiontype;

	public Transactionhistoryarchive() {
	}

	public Integer getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(Integer transactionid) {
		this.transactionid = transactionid;
	}

	public BigDecimal getActualcost() {
		return this.actualcost;
	}

	public void setActualcost(BigDecimal actualcost) {
		this.actualcost = actualcost;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getReferenceorderid() {
		return this.referenceorderid;
	}

	public void setReferenceorderid(Integer referenceorderid) {
		this.referenceorderid = referenceorderid;
	}

	public Integer getReferenceorderlineid() {
		return this.referenceorderlineid;
	}

	public void setReferenceorderlineid(Integer referenceorderlineid) {
		this.referenceorderlineid = referenceorderlineid;
	}

	public Timestamp getTransactiondate() {
		return this.transactiondate;
	}

	public void setTransactiondate(Timestamp transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getTransactiontype() {
		return this.transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

}