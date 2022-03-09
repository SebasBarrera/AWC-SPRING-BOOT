package co.edu.icesi.dev.uccareapp.transport.model.sales;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the currencyrate database table.
 * 
 */
@Entity
@NamedQuery(name="Currencyrate.findAll", query="SELECT c FROM Currencyrate c")
public class Currencyrate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CURRENCYRATE_CURRENCYRATEID_GENERATOR",allocationSize = 1, sequenceName="CURRENCYRATE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CURRENCYRATE_CURRENCYRATEID_GENERATOR")
	private Integer currencyrateid;

	private BigDecimal averagerate;

	private Timestamp currencyratedate;

	private BigDecimal endofdayrate;

	private Timestamp modifieddate;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name="fromcurrencycode")
	private Currency currency1;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name="tocurrencycode")
	private Currency currency2;

	//bi-directional many-to-one association to Salesorderheader
	@OneToMany(mappedBy="currencyrate")
	private List<Salesorderheader> salesorderheaders;

	public Currencyrate() {
	}

	public Integer getCurrencyrateid() {
		return this.currencyrateid;
	}

	public void setCurrencyrateid(Integer currencyrateid) {
		this.currencyrateid = currencyrateid;
	}

	public BigDecimal getAveragerate() {
		return this.averagerate;
	}

	public void setAveragerate(BigDecimal averagerate) {
		this.averagerate = averagerate;
	}

	public Timestamp getCurrencyratedate() {
		return this.currencyratedate;
	}

	public void setCurrencyratedate(Timestamp currencyratedate) {
		this.currencyratedate = currencyratedate;
	}

	public BigDecimal getEndofdayrate() {
		return this.endofdayrate;
	}

	public void setEndofdayrate(BigDecimal endofdayrate) {
		this.endofdayrate = endofdayrate;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Currency getCurrency1() {
		return this.currency1;
	}

	public void setCurrency1(Currency currency1) {
		this.currency1 = currency1;
	}

	public Currency getCurrency2() {
		return this.currency2;
	}

	public void setCurrency2(Currency currency2) {
		this.currency2 = currency2;
	}

	public List<Salesorderheader> getSalesorderheaders() {
		return this.salesorderheaders;
	}

	public void setSalesorderheaders(List<Salesorderheader> salesorderheaders) {
		this.salesorderheaders = salesorderheaders;
	}

	public Salesorderheader addSalesorderheader(Salesorderheader salesorderheader) {
		getSalesorderheaders().add(salesorderheader);
		salesorderheader.setCurrencyrate(this);

		return salesorderheader;
	}

	public Salesorderheader removeSalesorderheader(Salesorderheader salesorderheader) {
		getSalesorderheaders().remove(salesorderheader);
		salesorderheader.setCurrencyrate(null);

		return salesorderheader;
	}

}