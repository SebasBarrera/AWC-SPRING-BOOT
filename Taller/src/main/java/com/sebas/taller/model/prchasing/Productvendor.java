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
 * The persistent class for the productvendor database table.
 *
 */
@Entity
@NamedQuery(name = "Productvendor.findAll", query = "SELECT p FROM Productvendor p")
public class Productvendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductvendorPK id;

	private Integer averageleadtime;

	private BigDecimal lastreceiptcost;

	private Timestamp lastreceiptdate;

	private Integer maxorderqty;

	private Integer minorderqty;

	private Timestamp modifieddate;

	private Integer onorderqty;

	private BigDecimal standardprice;

	private String unitmeasurecode;

	// bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name = "businessentityid", insertable = false, updatable = false)
	private Vendor vendor;

	public Productvendor() {
	}

	public Integer getAverageleadtime() {
		return this.averageleadtime;
	}

	public ProductvendorPK getId() {
		return this.id;
	}

	public BigDecimal getLastreceiptcost() {
		return this.lastreceiptcost;
	}

	public Timestamp getLastreceiptdate() {
		return this.lastreceiptdate;
	}

	public Integer getMaxorderqty() {
		return this.maxorderqty;
	}

	public Integer getMinorderqty() {
		return this.minorderqty;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getOnorderqty() {
		return this.onorderqty;
	}

	public BigDecimal getStandardprice() {
		return this.standardprice;
	}

	public String getUnitmeasurecode() {
		return this.unitmeasurecode;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setAverageleadtime(Integer averageleadtime) {
		this.averageleadtime = averageleadtime;
	}

	public void setId(ProductvendorPK id) {
		this.id = id;
	}

	public void setLastreceiptcost(BigDecimal lastreceiptcost) {
		this.lastreceiptcost = lastreceiptcost;
	}

	public void setLastreceiptdate(Timestamp lastreceiptdate) {
		this.lastreceiptdate = lastreceiptdate;
	}

	public void setMaxorderqty(Integer maxorderqty) {
		this.maxorderqty = maxorderqty;
	}

	public void setMinorderqty(Integer minorderqty) {
		this.minorderqty = minorderqty;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setOnorderqty(Integer onorderqty) {
		this.onorderqty = onorderqty;
	}

	public void setStandardprice(BigDecimal standardprice) {
		this.standardprice = standardprice;
	}

	public void setUnitmeasurecode(String unitmeasurecode) {
		this.unitmeasurecode = unitmeasurecode;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}