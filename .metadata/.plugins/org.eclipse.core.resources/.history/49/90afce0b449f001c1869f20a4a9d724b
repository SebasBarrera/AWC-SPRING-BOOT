package co.edu.icesi.dev.uccareapp.transport.model.sales;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the salesorderheadersalesreason database table.
 *
 */
@Entity
@NamedQuery(name = "Salesorderheadersalesreason.findAll", query = "SELECT s FROM Salesorderheadersalesreason s")
public class Salesorderheadersalesreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalesorderheadersalesreasonPK id;

	private Timestamp modifieddate;

	// bi-directional many-to-one association to Salesorderheader
	@ManyToOne
	@JoinColumn(name = "salesorderid", insertable = false, updatable = false)
	private Salesorderheader salesorderheader;

	// bi-directional many-to-one association to Salesreason
	@ManyToOne
	@JoinColumn(name = "salesreasonid", insertable = false, updatable = false)
	private Salesreason salesreason;

	public Salesorderheadersalesreason() {
	}

	public SalesorderheadersalesreasonPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Salesorderheader getSalesorderheader() {
		return this.salesorderheader;
	}

	public Salesreason getSalesreason() {
		return this.salesreason;
	}

	public void setId(SalesorderheadersalesreasonPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setSalesorderheader(Salesorderheader salesorderheader) {
		this.salesorderheader = salesorderheader;
	}

	public void setSalesreason(Salesreason salesreason) {
		this.salesreason = salesreason;
	}

}