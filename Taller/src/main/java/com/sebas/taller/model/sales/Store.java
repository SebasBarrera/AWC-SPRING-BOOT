package com.sebas.taller.model.sales;

import java.io.Serializable;
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
 * The persistent class for the store database table.
 *
 */
@Entity
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "STORE_BUSINESSENTITYID_GENERATOR", allocationSize = 1, sequenceName = "STORE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_BUSINESSENTITYID_GENERATOR")
	private Integer businessentityid;

	private String demographics;

	private Timestamp modifieddate;

	private String name;

	private Integer rowguid;

	// bi-directional many-to-one association to Customer
	@OneToMany(mappedBy = "store")
	private List<Customer> customers;

	// bi-directional many-to-one association to Salesperson
	@ManyToOne
	@JoinColumn(name = "salespersonid")
	private Salesperson salesperson;

	public Store() {
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setStore(this);

		return customer;
	}

	public Integer getBusinessentityid() {
		return this.businessentityid;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public String getDemographics() {
		return this.demographics;
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

	public Salesperson getSalesperson() {
		return this.salesperson;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setStore(null);

		return customer;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void setDemographics(String demographics) {
		this.demographics = demographics;
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

	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
	}

}