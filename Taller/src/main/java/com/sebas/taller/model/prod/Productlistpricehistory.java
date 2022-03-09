package com.sebas.taller.model.prod;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the productlistpricehistory database table.
 *
 */
@Entity
@NamedQuery(name = "Productlistpricehistory.findAll", query = "SELECT p FROM Productlistpricehistory p")
public class Productlistpricehistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductlistpricehistoryPK id;

	private Timestamp enddate;

	private BigDecimal listprice;

	private Timestamp modifieddate;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "productid", insertable = false, updatable = false)
	private Product product;

	public Productlistpricehistory() {
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public ProductlistpricehistoryPK getId() {
		return this.id;
	}

	public BigDecimal getListprice() {
		return this.listprice;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public void setId(ProductlistpricehistoryPK id) {
		this.id = id;
	}

	public void setListprice(BigDecimal listprice) {
		this.listprice = listprice;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}