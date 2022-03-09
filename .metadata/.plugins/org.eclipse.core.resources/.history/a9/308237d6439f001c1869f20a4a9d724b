package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the transactionhistory database table.
 * 
 */
@Entity
@NamedQuery(name="Transactionhistory.findAll", query="SELECT t FROM Transactionhistory t")
public class Transactionhistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSACTIONHISTORY_TRANSACTIONID_GENERATOR",allocationSize = 1, sequenceName="TRANSACTIONHISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSACTIONHISTORY_TRANSACTIONID_GENERATOR")
	private Integer transactionid;

	private BigDecimal actualcost;

	private Timestamp modifieddate;

	private Integer quantity;

	private Integer referenceorderid;

	private Integer referenceorderlineid;

	private Timestamp transactiondate;

	private String transactiontype;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	public Transactionhistory() {
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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}