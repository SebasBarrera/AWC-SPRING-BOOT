package com.sebas.taller.model.prchasing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the shipmethod database table.
 *
 */
@Entity
@NamedQuery(name = "Shipmethod.findAll", query = "SELECT s FROM Shipmethod s")
public class Shipmethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SHIPMETHOD_SHIPMETHODID_GENERATOR", allocationSize = 1, sequenceName = "SHIPMETHOD_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIPMETHOD_SHIPMETHODID_GENERATOR")
	private Integer shipmethodid;

	private Timestamp modifieddate;

	private String name;

	private Integer rowguid;

	private BigDecimal shipbase;

	private BigDecimal shiprate;

	// bi-directional many-to-one association to Purchaseorderheader
	@OneToMany(mappedBy = "shipmethod")
	private List<Purchaseorderheader> purchaseorderheaders;

	public Shipmethod() {
	}

	public Purchaseorderheader addPurchaseorderheader(Purchaseorderheader purchaseorderheader) {
		getPurchaseorderheaders().add(purchaseorderheader);
		purchaseorderheader.setShipmethod(this);

		return purchaseorderheader;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Purchaseorderheader> getPurchaseorderheaders() {
		return this.purchaseorderheaders;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public BigDecimal getShipbase() {
		return this.shipbase;
	}

	public Integer getShipmethodid() {
		return this.shipmethodid;
	}

	public BigDecimal getShiprate() {
		return this.shiprate;
	}

	public Purchaseorderheader removePurchaseorderheader(Purchaseorderheader purchaseorderheader) {
		getPurchaseorderheaders().remove(purchaseorderheader);
		purchaseorderheader.setShipmethod(null);

		return purchaseorderheader;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPurchaseorderheaders(List<Purchaseorderheader> purchaseorderheaders) {
		this.purchaseorderheaders = purchaseorderheaders;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setShipbase(BigDecimal shipbase) {
		this.shipbase = shipbase;
	}

	public void setShipmethodid(Integer shipmethodid) {
		this.shipmethodid = shipmethodid;
	}

	public void setShiprate(BigDecimal shiprate) {
		this.shiprate = shiprate;
	}

}