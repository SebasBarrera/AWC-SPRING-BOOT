package com.sebas.taller.model.prchasing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the purchaseorderdetail database table.
 *
 */
@Entity
@NamedQuery(name = "Purchaseorderdetail.findAll", query = "SELECT p FROM Purchaseorderdetail p")
public class Purchaseorderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PurchaseorderdetailPK id;

	private Timestamp duedate;

	private Timestamp modifieddate;

	private Integer orderqty;

	private Integer productid;

	private BigDecimal receivedqty;

	private BigDecimal rejectedqty;

	private BigDecimal unitprice;

	// bi-directional many-to-one association to Purchaseorderheader
	@ManyToOne
	@JoinColumn(name = "purchaseorderid", insertable = false, updatable = false)
	private Purchaseorderheader purchaseorderheader;

	public Purchaseorderdetail() {
	}

	public Timestamp getDuedate() {
		return this.duedate;
	}

	public PurchaseorderdetailPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getOrderqty() {
		return this.orderqty;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public Purchaseorderheader getPurchaseorderheader() {
		return this.purchaseorderheader;
	}

	public BigDecimal getReceivedqty() {
		return this.receivedqty;
	}

	public BigDecimal getRejectedqty() {
		return this.rejectedqty;
	}

	public BigDecimal getUnitprice() {
		return this.unitprice;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public void setId(PurchaseorderdetailPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setOrderqty(Integer orderqty) {
		this.orderqty = orderqty;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public void setPurchaseorderheader(Purchaseorderheader purchaseorderheader) {
		this.purchaseorderheader = purchaseorderheader;
	}

	public void setReceivedqty(BigDecimal receivedqty) {
		this.receivedqty = receivedqty;
	}

	public void setRejectedqty(BigDecimal rejectedqty) {
		this.rejectedqty = rejectedqty;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}

}