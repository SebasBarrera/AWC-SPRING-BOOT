package com.sebas.taller.model.sales;

import java.io.Serializable;
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
 * The persistent class for the salesreason database table.
 *
 */
@Entity
@NamedQuery(name = "Salesreason.findAll", query = "SELECT s FROM Salesreason s")
public class Salesreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SALESREASON_SALESREASONID_GENERATOR", allocationSize = 1, sequenceName = "SALESREASON_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESREASON_SALESREASONID_GENERATOR")
	private Integer salesreasonid;

	private Timestamp modifieddate;

	private String name;

	private String reasontype;

	// bi-directional many-to-one association to Salesorderheadersalesreason
	@OneToMany(mappedBy = "salesreason")
	private List<Salesorderheadersalesreason> salesorderheadersalesreasons;

	public Salesreason() {
	}

	public Salesorderheadersalesreason addSalesorderheadersalesreason(
			Salesorderheadersalesreason salesorderheadersalesreason) {
		getSalesorderheadersalesreasons().add(salesorderheadersalesreason);
		salesorderheadersalesreason.setSalesreason(this);

		return salesorderheadersalesreason;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public String getReasontype() {
		return this.reasontype;
	}

	public List<Salesorderheadersalesreason> getSalesorderheadersalesreasons() {
		return this.salesorderheadersalesreasons;
	}

	public Integer getSalesreasonid() {
		return this.salesreasonid;
	}

	public Salesorderheadersalesreason removeSalesorderheadersalesreason(
			Salesorderheadersalesreason salesorderheadersalesreason) {
		getSalesorderheadersalesreasons().remove(salesorderheadersalesreason);
		salesorderheadersalesreason.setSalesreason(null);

		return salesorderheadersalesreason;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReasontype(String reasontype) {
		this.reasontype = reasontype;
	}

	public void setSalesorderheadersalesreasons(List<Salesorderheadersalesreason> salesorderheadersalesreasons) {
		this.salesorderheadersalesreasons = salesorderheadersalesreasons;
	}

	public void setSalesreasonid(Integer salesreasonid) {
		this.salesreasonid = salesreasonid;
	}

}