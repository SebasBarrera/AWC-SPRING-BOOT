package com.sebas.taller.model.sales;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the salesterritoryhistory database table.
 *
 */
@Entity
@NamedQuery(name = "Salesterritoryhistory.findAll", query = "SELECT s FROM Salesterritoryhistory s")
public class Salesterritoryhistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalesterritoryhistoryPK id;

	private Timestamp enddate;

	private Timestamp modifieddate;

	private Integer rowguid;

	// bi-directional many-to-one association to Salesperson
	@ManyToOne
	@JoinColumn(name = "businessentityid", insertable = false, updatable = false)
	private Salesperson salesperson;

	// bi-directional many-to-one association to Salesterritory
	@ManyToOne
	@JoinColumn(name = "territoryid", insertable = false, updatable = false)
	private Salesterritory salesterritory;

	public Salesterritoryhistory() {
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public SalesterritoryhistoryPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Salesperson getSalesperson() {
		return this.salesperson;
	}

	public Salesterritory getSalesterritory() {
		return this.salesterritory;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public void setId(SalesterritoryhistoryPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
	}

	public void setSalesterritory(Salesterritory salesterritory) {
		this.salesterritory = salesterritory;
	}

}