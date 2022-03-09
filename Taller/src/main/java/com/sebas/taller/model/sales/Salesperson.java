package com.sebas.taller.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the salesperson database table.
 *
 */
@Entity
@NamedQuery(name = "Salesperson.findAll", query = "SELECT s FROM Salesperson s")
public class Salesperson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SALESPERSON_BUSINESSENTITYID_GENERATOR", allocationSize = 1, sequenceName = "SALESPERSON_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESPERSON_BUSINESSENTITYID_GENERATOR")
	private Integer businessentityid;

	private BigDecimal bonus;

	private BigDecimal commissionpct;

	private Timestamp modifieddate;

	private Integer rowguid;

	private BigDecimal saleslastyear;

	private BigDecimal salesquota;

	private BigDecimal salesytd;

	// bi-directional many-to-one association to Salesorderheader
	@OneToMany(mappedBy = "salesperson")
	private List<Salesorderheader> salesorderheaders;

	// bi-directional many-to-one association to Salesterritory
	@ManyToOne
	@JoinColumn(name = "territoryid")
	private Salesterritory salesterritory;

	// bi-directional many-to-one association to Salespersonquotahistory
	@OneToMany(mappedBy = "salesperson")
	private List<Salespersonquotahistory> salespersonquotahistories;

	// bi-directional many-to-one association to Salesterritoryhistory
	@OneToMany(mappedBy = "salesperson")
	private List<Salesterritoryhistory> salesterritoryhistories;

	// bi-directional many-to-one association to Store
	@OneToMany(mappedBy = "salesperson")
	private List<Store> stores;

	public Salesperson() {
	}

	public Salesorderheader addSalesorderheader(Salesorderheader salesorderheader) {
		getSalesorderheaders().add(salesorderheader);
		salesorderheader.setSalesperson(this);

		return salesorderheader;
	}

	public Salespersonquotahistory addSalespersonquotahistory(Salespersonquotahistory salespersonquotahistory) {
		getSalespersonquotahistories().add(salespersonquotahistory);
		salespersonquotahistory.setSalesperson(this);

		return salespersonquotahistory;
	}

	public Salesterritoryhistory addSalesterritoryhistory(Salesterritoryhistory salesterritoryhistory) {
		getSalesterritoryhistories().add(salesterritoryhistory);
		salesterritoryhistory.setSalesperson(this);

		return salesterritoryhistory;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setSalesperson(this);

		return store;
	}

	public BigDecimal getBonus() {
		return this.bonus;
	}

	public Integer getBusinessentityid() {
		return this.businessentityid;
	}

	public BigDecimal getCommissionpct() {
		return this.commissionpct;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public BigDecimal getSaleslastyear() {
		return this.saleslastyear;
	}

	public List<Salesorderheader> getSalesorderheaders() {
		return this.salesorderheaders;
	}

	public List<Salespersonquotahistory> getSalespersonquotahistories() {
		return this.salespersonquotahistories;
	}

	public BigDecimal getSalesquota() {
		return this.salesquota;
	}

	public Salesterritory getSalesterritory() {
		return this.salesterritory;
	}

	public List<Salesterritoryhistory> getSalesterritoryhistories() {
		return this.salesterritoryhistories;
	}

	public BigDecimal getSalesytd() {
		return this.salesytd;
	}

	public List<Store> getStores() {
		return this.stores;
	}

	public Salesorderheader removeSalesorderheader(Salesorderheader salesorderheader) {
		getSalesorderheaders().remove(salesorderheader);
		salesorderheader.setSalesperson(null);

		return salesorderheader;
	}

	public Salespersonquotahistory removeSalespersonquotahistory(Salespersonquotahistory salespersonquotahistory) {
		getSalespersonquotahistories().remove(salespersonquotahistory);
		salespersonquotahistory.setSalesperson(null);

		return salespersonquotahistory;
	}

	public Salesterritoryhistory removeSalesterritoryhistory(Salesterritoryhistory salesterritoryhistory) {
		getSalesterritoryhistories().remove(salesterritoryhistory);
		salesterritoryhistory.setSalesperson(null);

		return salesterritoryhistory;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setSalesperson(null);

		return store;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public void setCommissionpct(BigDecimal commissionpct) {
		this.commissionpct = commissionpct;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSaleslastyear(BigDecimal saleslastyear) {
		this.saleslastyear = saleslastyear;
	}

	public void setSalesorderheaders(List<Salesorderheader> salesorderheaders) {
		this.salesorderheaders = salesorderheaders;
	}

	public void setSalespersonquotahistories(List<Salespersonquotahistory> salespersonquotahistories) {
		this.salespersonquotahistories = salespersonquotahistories;
	}

	public void setSalesquota(BigDecimal salesquota) {
		this.salesquota = salesquota;
	}

	public void setSalesterritory(Salesterritory salesterritory) {
		this.salesterritory = salesterritory;
	}

	public void setSalesterritoryhistories(List<Salesterritoryhistory> salesterritoryhistories) {
		this.salesterritoryhistories = salesterritoryhistories;
	}

	public void setSalesytd(BigDecimal salesytd) {
		this.salesytd = salesytd;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

}