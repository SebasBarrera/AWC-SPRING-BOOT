package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the billofmaterials database table.
 * 
 */
@Entity
@Table(name="billofmaterials")
@NamedQuery(name="Billofmaterial.findAll", query="SELECT b FROM Billofmaterial b")
public class Billofmaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BILLOFMATERIALS_BILLOFMATERIALSID_GENERATOR",allocationSize = 1, sequenceName="BILLOFMATERIALS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BILLOFMATERIALS_BILLOFMATERIALSID_GENERATOR")
	private Integer billofmaterialsid;

	private Integer bomlevel;

	private Timestamp enddate;

	private Timestamp modifieddate;

	private BigDecimal perassemblyqty;

	private Timestamp startdate;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="componentid")
	private Product product1;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productassemblyid")
	private Product product2;

	//bi-directional many-to-one association to Unitmeasure
	@ManyToOne
	@JoinColumn(name="unitmeasurecode")
	private Unitmeasure unitmeasure;

	public Billofmaterial() {
	}

	public Integer getBillofmaterialsid() {
		return this.billofmaterialsid;
	}

	public void setBillofmaterialsid(Integer billofmaterialsid) {
		this.billofmaterialsid = billofmaterialsid;
	}

	public Integer getBomlevel() {
		return this.bomlevel;
	}

	public void setBomlevel(Integer bomlevel) {
		this.bomlevel = bomlevel;
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

	public BigDecimal getPerassemblyqty() {
		return this.perassemblyqty;
	}

	public void setPerassemblyqty(BigDecimal perassemblyqty) {
		this.perassemblyqty = perassemblyqty;
	}

	public Timestamp getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public Product getProduct1() {
		return this.product1;
	}

	public void setProduct1(Product product1) {
		this.product1 = product1;
	}

	public Product getProduct2() {
		return this.product2;
	}

	public void setProduct2(Product product2) {
		this.product2 = product2;
	}

	public Unitmeasure getUnitmeasure() {
		return this.unitmeasure;
	}

	public void setUnitmeasure(Unitmeasure unitmeasure) {
		this.unitmeasure = unitmeasure;
	}

}