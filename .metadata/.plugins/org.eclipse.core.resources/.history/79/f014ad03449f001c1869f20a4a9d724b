package co.edu.icesi.dev.uccareapp.transport.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the salesorderdetail database table.
 *
 */
@Entity
@NamedQuery(name = "Salesorderdetail.findAll", query = "SELECT s FROM Salesorderdetail s")
public class Salesorderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalesorderdetailPK id;

	private String carriertrackingnumber;

	private Timestamp modifieddate;

	private Integer orderqty;

	private Integer rowguid;

	private BigDecimal unitprice;

	private BigDecimal unitpricediscount;

	// bi-directional many-to-one association to Salesorderheader
	@ManyToOne
	@JoinColumn(name = "salesorderid", insertable = false, updatable = false)
	private Salesorderheader salesorderheader;

	// bi-directional many-to-one association to Specialofferproduct
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "productid", referencedColumnName = "productid", insertable = false, updatable = false),
			@JoinColumn(name = "specialofferid", referencedColumnName = "specialofferid", insertable = false, updatable = false) })
	private Specialofferproduct specialofferproduct;

	public Salesorderdetail() {
	}

	public String getCarriertrackingnumber() {
		return this.carriertrackingnumber;
	}

	public SalesorderdetailPK getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getOrderqty() {
		return this.orderqty;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Salesorderheader getSalesorderheader() {
		return this.salesorderheader;
	}

	public Specialofferproduct getSpecialofferproduct() {
		return this.specialofferproduct;
	}

	public BigDecimal getUnitprice() {
		return this.unitprice;
	}

	public BigDecimal getUnitpricediscount() {
		return this.unitpricediscount;
	}

	public void setCarriertrackingnumber(String carriertrackingnumber) {
		this.carriertrackingnumber = carriertrackingnumber;
	}

	public void setId(SalesorderdetailPK id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setOrderqty(Integer orderqty) {
		this.orderqty = orderqty;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSalesorderheader(Salesorderheader salesorderheader) {
		this.salesorderheader = salesorderheader;
	}

	public void setSpecialofferproduct(Specialofferproduct specialofferproduct) {
		this.specialofferproduct = specialofferproduct;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}

	public void setUnitpricediscount(BigDecimal unitpricediscount) {
		this.unitpricediscount = unitpricediscount;
	}

}