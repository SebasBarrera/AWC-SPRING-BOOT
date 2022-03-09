package co.edu.icesi.dev.uccareapp.transport.model.sales;

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
 * The persistent class for the salesorderheader database table.
 *
 */
@Entity
@NamedQuery(name = "Salesorderheader.findAll", query = "SELECT s FROM Salesorderheader s")
public class Salesorderheader implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SALESORDERHEADER_SALESORDERID_GENERATOR", allocationSize = 1, sequenceName = "SALESORDERHEADER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESORDERHEADER_SALESORDERID_GENERATOR")
	private Integer salesorderid;

	private String accountnumber;

	private Integer billtoaddressid;

	private String comment;

	private String creditcardapprovalcode;

	private Timestamp duedate;

	private BigDecimal freight;

	private Timestamp modifieddate;

	private String onlineorderflag;

	private Timestamp orderdate;

	private String purchaseordernumber;

	private Integer revisionnumber;

	private Integer rowguid;

	private Timestamp shipdate;

	private Integer shipmethodid;

	private Integer shiptoaddressid;

	private Integer status;

	private BigDecimal subtotal;

	private BigDecimal taxamt;

	private BigDecimal totaldue;

	// bi-directional many-to-one association to Salesorderdetail
	@OneToMany(mappedBy = "salesorderheader")
	private List<Salesorderdetail> salesorderdetails;

	// bi-directional many-to-one association to Creditcard
	@ManyToOne
	@JoinColumn(name = "creditcardid")
	private Creditcard creditcard;

	// bi-directional many-to-one association to Currencyrate
	@ManyToOne
	@JoinColumn(name = "currencyrateid")
	private Currencyrate currencyrate;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "customerid")
	private Customer customer;

	// bi-directional many-to-one association to Salesperson
	@ManyToOne
	@JoinColumn(name = "salespersonid")
	private Salesperson salesperson;

	// bi-directional many-to-one association to Salesterritory
	@ManyToOne
	@JoinColumn(name = "territoryid")
	private Salesterritory salesterritory;

	// bi-directional many-to-one association to Salesorderheadersalesreason
	@OneToMany(mappedBy = "salesorderheader")
	private List<Salesorderheadersalesreason> salesorderheadersalesreasons;

	public Salesorderheader() {
	}

	public Salesorderdetail addSalesorderdetail(Salesorderdetail salesorderdetail) {
		getSalesorderdetails().add(salesorderdetail);
		salesorderdetail.setSalesorderheader(this);

		return salesorderdetail;
	}

	public Salesorderheadersalesreason addSalesorderheadersalesreason(
			Salesorderheadersalesreason salesorderheadersalesreason) {
		getSalesorderheadersalesreasons().add(salesorderheadersalesreason);
		salesorderheadersalesreason.setSalesorderheader(this);

		return salesorderheadersalesreason;
	}

	public String getAccountnumber() {
		return this.accountnumber;
	}

	public Integer getBilltoaddressid() {
		return this.billtoaddressid;
	}

	public String getComment() {
		return this.comment;
	}

	public Creditcard getCreditcard() {
		return this.creditcard;
	}

	public String getCreditcardapprovalcode() {
		return this.creditcardapprovalcode;
	}

	public Currencyrate getCurrencyrate() {
		return this.currencyrate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public Timestamp getDuedate() {
		return this.duedate;
	}

	public BigDecimal getFreight() {
		return this.freight;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getOnlineorderflag() {
		return this.onlineorderflag;
	}

	public Timestamp getOrderdate() {
		return this.orderdate;
	}

	public String getPurchaseordernumber() {
		return this.purchaseordernumber;
	}

	public Integer getRevisionnumber() {
		return this.revisionnumber;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public List<Salesorderdetail> getSalesorderdetails() {
		return this.salesorderdetails;
	}

	public List<Salesorderheadersalesreason> getSalesorderheadersalesreasons() {
		return this.salesorderheadersalesreasons;
	}

	public Integer getSalesorderid() {
		return this.salesorderid;
	}

	public Salesperson getSalesperson() {
		return this.salesperson;
	}

	public Salesterritory getSalesterritory() {
		return this.salesterritory;
	}

	public Timestamp getShipdate() {
		return this.shipdate;
	}

	public Integer getShipmethodid() {
		return this.shipmethodid;
	}

	public Integer getShiptoaddressid() {
		return this.shiptoaddressid;
	}

	public Integer getStatus() {
		return this.status;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public BigDecimal getTaxamt() {
		return this.taxamt;
	}

	public BigDecimal getTotaldue() {
		return this.totaldue;
	}

	public Salesorderdetail removeSalesorderdetail(Salesorderdetail salesorderdetail) {
		getSalesorderdetails().remove(salesorderdetail);
		salesorderdetail.setSalesorderheader(null);

		return salesorderdetail;
	}

	public Salesorderheadersalesreason removeSalesorderheadersalesreason(
			Salesorderheadersalesreason salesorderheadersalesreason) {
		getSalesorderheadersalesreasons().remove(salesorderheadersalesreason);
		salesorderheadersalesreason.setSalesorderheader(null);

		return salesorderheadersalesreason;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public void setBilltoaddressid(Integer billtoaddressid) {
		this.billtoaddressid = billtoaddressid;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCreditcard(Creditcard creditcard) {
		this.creditcard = creditcard;
	}

	public void setCreditcardapprovalcode(String creditcardapprovalcode) {
		this.creditcardapprovalcode = creditcardapprovalcode;
	}

	public void setCurrencyrate(Currencyrate currencyrate) {
		this.currencyrate = currencyrate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setOnlineorderflag(String onlineorderflag) {
		this.onlineorderflag = onlineorderflag;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	public void setPurchaseordernumber(String purchaseordernumber) {
		this.purchaseordernumber = purchaseordernumber;
	}

	public void setRevisionnumber(Integer revisionnumber) {
		this.revisionnumber = revisionnumber;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSalesorderdetails(List<Salesorderdetail> salesorderdetails) {
		this.salesorderdetails = salesorderdetails;
	}

	public void setSalesorderheadersalesreasons(List<Salesorderheadersalesreason> salesorderheadersalesreasons) {
		this.salesorderheadersalesreasons = salesorderheadersalesreasons;
	}

	public void setSalesorderid(Integer salesorderid) {
		this.salesorderid = salesorderid;
	}

	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
	}

	public void setSalesterritory(Salesterritory salesterritory) {
		this.salesterritory = salesterritory;
	}

	public void setShipdate(Timestamp shipdate) {
		this.shipdate = shipdate;
	}

	public void setShipmethodid(Integer shipmethodid) {
		this.shipmethodid = shipmethodid;
	}

	public void setShiptoaddressid(Integer shiptoaddressid) {
		this.shiptoaddressid = shiptoaddressid;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public void setTaxamt(BigDecimal taxamt) {
		this.taxamt = taxamt;
	}

	public void setTotaldue(BigDecimal totaldue) {
		this.totaldue = totaldue;
	}

}