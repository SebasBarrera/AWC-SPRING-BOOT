package com.sebas.taller.model.sales;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the salesterritory database table.
 *
 */
@Entity
@NamedQuery(name = "Salesterritory.findAll", query = "SELECT s FROM Salesterritory s")
public class Salesterritory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SALESTERRITORY_TERRITORYID_GENERATOR", allocationSize = 1, sequenceName = "SALESTERRITORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESTERRITORY_TERRITORYID_GENERATOR")
	private Integer territoryid;

	private BigDecimal costlastyear;

	private BigDecimal costytd;

	private String countryregioncode;

	private String salesgroup;

	private Timestamp modifieddate;

	private String name;

	private Integer rowguid;

	private BigDecimal saleslastyear;

	private BigDecimal salesytd;

	// bi-directional many-to-one association to Customer
	@OneToMany(mappedBy = "salesterritory")
	private List<Customer> customers;

	// bi-directional many-to-one association to Salesorderheader
	@OneToMany(mappedBy = "salesterritory")
	@JsonIgnore
	private List<Salesorderheader> salesorderheaders;

	// bi-directional many-to-one association to Salesperson
	@OneToMany(mappedBy = "salesterritory")
	private List<Salesperson> salespersons;

	// bi-directional many-to-one association to Salesterritoryhistory
	@OneToMany(mappedBy = "salesterritory")
	private List<Salesterritoryhistory> salesterritoryhistories;

	public Salesterritory() {
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setSalesterritory(this);

		return customer;
	}

	public Salesorderheader addSalesorderheader(Salesorderheader salesorderheader) {
		getSalesorderheaders().add(salesorderheader);
		salesorderheader.setSalesterritory(this);

		return salesorderheader;
	}

	public Salesperson addSalesperson(Salesperson salesperson) {
		getSalespersons().add(salesperson);
		salesperson.setSalesterritory(this);

		return salesperson;
	}

	public Salesterritoryhistory addSalesterritoryhistory(Salesterritoryhistory salesterritoryhistory) {
		getSalesterritoryhistories().add(salesterritoryhistory);
		salesterritoryhistory.setSalesterritory(this);

		return salesterritoryhistory;
	}

	public BigDecimal getCostlastyear() {
		return this.costlastyear;
	}

	public BigDecimal getCostytd() {
		return this.costytd;
	}

	public String getCountryregioncode() {
		return this.countryregioncode;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public String getSalesGroup() {
		return this.salesgroup;
	}

	public BigDecimal getSaleslastyear() {
		return this.saleslastyear;
	}

	public List<Salesorderheader> getSalesorderheaders() {
		return this.salesorderheaders;
	}

	public List<Salesperson> getSalespersons() {
		return this.salespersons;
	}

	public List<Salesterritoryhistory> getSalesterritoryhistories() {
		return this.salesterritoryhistories;
	}

	public BigDecimal getSalesytd() {
		return this.salesytd;
	}

	public Integer getTerritoryid() {
		return this.territoryid;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setSalesterritory(null);

		return customer;
	}

	public Salesorderheader removeSalesorderheader(Salesorderheader salesorderheader) {
		getSalesorderheaders().remove(salesorderheader);
		salesorderheader.setSalesterritory(null);

		return salesorderheader;
	}

	public Salesperson removeSalesperson(Salesperson salesperson) {
		getSalespersons().remove(salesperson);
		salesperson.setSalesterritory(null);

		return salesperson;
	}

	public Salesterritoryhistory removeSalesterritoryhistory(Salesterritoryhistory salesterritoryhistory) {
		getSalesterritoryhistories().remove(salesterritoryhistory);
		salesterritoryhistory.setSalesterritory(null);

		return salesterritoryhistory;
	}

	public void setCostlastyear(BigDecimal costlastyear) {
		this.costlastyear = costlastyear;
	}

	public void setCostytd(BigDecimal costytd) {
		this.costytd = costytd;
	}

	public void setCountryregioncode(String countryregioncode) {
		this.countryregioncode = countryregioncode;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSalesGroup(String salesgroup) {
		this.salesgroup = salesgroup;
	}

	public void setSaleslastyear(BigDecimal saleslastyear) {
		this.saleslastyear = saleslastyear;
	}

	public void setSalesorderheaders(List<Salesorderheader> salesorderheaders) {
		this.salesorderheaders = salesorderheaders;
	}

	public void setSalespersons(List<Salesperson> salespersons) {
		this.salespersons = salespersons;
	}

	public void setSalesterritoryhistories(List<Salesterritoryhistory> salesterritoryhistories) {
		this.salesterritoryhistories = salesterritoryhistories;
	}

	public void setSalesytd(BigDecimal salesytd) {
		this.salesytd = salesytd;
	}

	public void setTerritoryid(Integer territoryid) {
		this.territoryid = territoryid;
	}

}