package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the workorder database table.
 * 
 */
@Entity
@NamedQuery(name="Workorder.findAll", query="SELECT w FROM Workorder w")
public class Workorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDER_WORKORDERID_GENERATOR",allocationSize = 1, sequenceName="WORKORDER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDER_WORKORDERID_GENERATOR")
	private Integer workorderid;

	private Timestamp duedate;

	private Timestamp enddate;

	private Timestamp modifieddate;

	private Integer orderqty;

	private Integer scrappedqty;

	private Timestamp startdate;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	//bi-directional many-to-one association to Scrapreason
	@ManyToOne
	@JoinColumn(name="scrapreasonid")
	private Scrapreason scrapreason;

	//bi-directional many-to-one association to Workorderrouting
	@OneToMany(mappedBy="workorder")
	private List<Workorderrouting> workorderroutings;

	public Workorder() {
	}

	public Integer getWorkorderid() {
		return this.workorderid;
	}

	public void setWorkorderid(Integer workorderid) {
		this.workorderid = workorderid;
	}

	public Timestamp getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Integer getOrderqty() {
		return this.orderqty;
	}

	public void setOrderqty(Integer orderqty) {
		this.orderqty = orderqty;
	}

	public Integer getScrappedqty() {
		return this.scrappedqty;
	}

	public void setScrappedqty(Integer scrappedqty) {
		this.scrappedqty = scrappedqty;
	}

	public Timestamp getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Scrapreason getScrapreason() {
		return this.scrapreason;
	}

	public void setScrapreason(Scrapreason scrapreason) {
		this.scrapreason = scrapreason;
	}

	public List<Workorderrouting> getWorkorderroutings() {
		return this.workorderroutings;
	}

	public void setWorkorderroutings(List<Workorderrouting> workorderroutings) {
		this.workorderroutings = workorderroutings;
	}

	public Workorderrouting addWorkorderrouting(Workorderrouting workorderrouting) {
		getWorkorderroutings().add(workorderrouting);
		workorderrouting.setWorkorder(this);

		return workorderrouting;
	}

	public Workorderrouting removeWorkorderrouting(Workorderrouting workorderrouting) {
		getWorkorderroutings().remove(workorderrouting);
		workorderrouting.setWorkorder(null);

		return workorderrouting;
	}

}