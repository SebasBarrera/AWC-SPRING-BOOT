package co.edu.icesi.dev.uccareapp.transport.model.sales;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the creditcard database table.
 * 
 */
@Entity
@NamedQuery(name="Creditcard.findAll", query="SELECT c FROM Creditcard c")
public class Creditcard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CREDITCARD_CREDITCARDID_GENERATOR",allocationSize = 1, sequenceName="CREDITCARD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CREDITCARD_CREDITCARDID_GENERATOR")
	private Integer creditcardid;

	private String cardnumber;

	private String cardtype;

	private Integer expmonth;

	private Integer expyear;

	private Timestamp modifieddate;

	//bi-directional many-to-one association to Personcreditcard
	@OneToMany(mappedBy="creditcard")
	private List<Personcreditcard> personcreditcards;

	//bi-directional many-to-one association to Salesorderheader
	@OneToMany(mappedBy="creditcard")
	private List<Salesorderheader> salesorderheaders;

	public Creditcard() {
	}

	public Integer getCreditcardid() {
		return this.creditcardid;
	}

	public void setCreditcardid(Integer creditcardid) {
		this.creditcardid = creditcardid;
	}

	public String getCardnumber() {
		return this.cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public Integer getExpmonth() {
		return this.expmonth;
	}

	public void setExpmonth(Integer expmonth) {
		this.expmonth = expmonth;
	}

	public Integer getExpyear() {
		return this.expyear;
	}

	public void setExpyear(Integer expyear) {
		this.expyear = expyear;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public List<Personcreditcard> getPersoncreditcards() {
		return this.personcreditcards;
	}

	public void setPersoncreditcards(List<Personcreditcard> personcreditcards) {
		this.personcreditcards = personcreditcards;
	}

	public Personcreditcard addPersoncreditcard(Personcreditcard personcreditcard) {
		getPersoncreditcards().add(personcreditcard);
		personcreditcard.setCreditcard(this);

		return personcreditcard;
	}

	public Personcreditcard removePersoncreditcard(Personcreditcard personcreditcard) {
		getPersoncreditcards().remove(personcreditcard);
		personcreditcard.setCreditcard(null);

		return personcreditcard;
	}

	public List<Salesorderheader> getSalesorderheaders() {
		return this.salesorderheaders;
	}

	public void setSalesorderheaders(List<Salesorderheader> salesorderheaders) {
		this.salesorderheaders = salesorderheaders;
	}

	public Salesorderheader addSalesorderheader(Salesorderheader salesorderheader) {
		getSalesorderheaders().add(salesorderheader);
		salesorderheader.setCreditcard(this);

		return salesorderheader;
	}

	public Salesorderheader removeSalesorderheader(Salesorderheader salesorderheader) {
		getSalesorderheaders().remove(salesorderheader);
		salesorderheader.setCreditcard(null);

		return salesorderheader;
	}

}