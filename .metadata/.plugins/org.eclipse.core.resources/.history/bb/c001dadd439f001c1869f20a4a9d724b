package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
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
 * The persistent class for the product database table.
 *
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCT_PRODUCTID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCTID_GENERATOR")
	private Integer productid;

	@Column(name = "class")
	private String class_;

	private String color;

	private Integer daystomanufacture;

	private Timestamp discontinueddate;

	private String finishedgoodsflag;

	private BigDecimal listprice;

	private String makeflag;

	private Timestamp modifieddate;

	private String name;

	private String productline;

	private String productnumber;

	private Integer reorderpoint;

	private Integer rowguid;

	private Integer safetystocklevel;

	private Timestamp sellenddate;

	private Timestamp sellstartdate;

	private String size;

	private BigDecimal standardcost;

	private String style;

	private BigDecimal weight;

	// bi-directional many-to-one association to Billofmaterial
	@OneToMany(mappedBy = "product1")
	private List<Billofmaterial> billofmaterials1;

	// bi-directional many-to-one association to Billofmaterial
	@OneToMany(mappedBy = "product2")
	private List<Billofmaterial> billofmaterials2;

	// bi-directional many-to-one association to Productmodel
	@ManyToOne
	@JoinColumn(name = "productmodelid")
	private Productmodel productmodel;

	// bi-directional many-to-one association to Productsubcategory
	@ManyToOne
	@JoinColumn(name = "productsubcategoryid")
	private Productsubcategory productsubcategory;

	// bi-directional many-to-one association to Unitmeasure
	@ManyToOne
	@JoinColumn(name = "sizeunitmeasurecode")
	private Unitmeasure unitmeasure1;

	// bi-directional many-to-one association to Unitmeasure
	@ManyToOne
	@JoinColumn(name = "weightunitmeasurecode")
	private Unitmeasure unitmeasure2;

	// bi-directional many-to-one association to Productcosthistory
	@OneToMany(mappedBy = "product")
	private List<Productcosthistory> productcosthistories;

	// bi-directional many-to-one association to Productdocument
	@OneToMany(mappedBy = "product")
	private List<Productdocument> productdocuments;

	// bi-directional many-to-one association to Productinventory
	@OneToMany(mappedBy = "product")
	private List<Productinventory> productinventories;

	// bi-directional many-to-one association to Productlistpricehistory
	@OneToMany(mappedBy = "product")
	private List<Productlistpricehistory> productlistpricehistories;

	// bi-directional many-to-one association to Productproductphoto
	@OneToMany(mappedBy = "product")
	private List<Productproductphoto> productproductphotos;

	// bi-directional many-to-one association to Productreview
	@OneToMany(mappedBy = "product")
	private List<Productreview> productreviews;

	// bi-directional many-to-one association to Transactionhistory
	@OneToMany(mappedBy = "product")
	private List<Transactionhistory> transactionhistories;

	// bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy = "product")
	private List<Workorder> workorders;

	public Product() {
	}

	public Billofmaterial addBillofmaterials1(Billofmaterial billofmaterials1) {
		getBillofmaterials1().add(billofmaterials1);
		billofmaterials1.setProduct1(this);

		return billofmaterials1;
	}

	public Billofmaterial addBillofmaterials2(Billofmaterial billofmaterials2) {
		getBillofmaterials2().add(billofmaterials2);
		billofmaterials2.setProduct2(this);

		return billofmaterials2;
	}

	public Productcosthistory addProductcosthistory(Productcosthistory productcosthistory) {
		getProductcosthistories().add(productcosthistory);
		productcosthistory.setProduct(this);

		return productcosthistory;
	}

	public Productdocument addProductdocument(Productdocument productdocument) {
		getProductdocuments().add(productdocument);
		productdocument.setProduct(this);

		return productdocument;
	}

	public Productinventory addProductinventory(Productinventory productinventory) {
		getProductinventories().add(productinventory);
		productinventory.setProduct(this);

		return productinventory;
	}

	public Productlistpricehistory addProductlistpricehistory(Productlistpricehistory productlistpricehistory) {
		getProductlistpricehistories().add(productlistpricehistory);
		productlistpricehistory.setProduct(this);

		return productlistpricehistory;
	}

	public Productproductphoto addProductproductphoto(Productproductphoto productproductphoto) {
		getProductproductphotos().add(productproductphoto);
		productproductphoto.setProduct(this);

		return productproductphoto;
	}

	public Productreview addProductreview(Productreview productreview) {
		getProductreviews().add(productreview);
		productreview.setProduct(this);

		return productreview;
	}

	public Transactionhistory addTransactionhistory(Transactionhistory transactionhistory) {
		getTransactionhistories().add(transactionhistory);
		transactionhistory.setProduct(this);

		return transactionhistory;
	}

	public Workorder addWorkorder(Workorder workorder) {
		getWorkorders().add(workorder);
		workorder.setProduct(this);

		return workorder;
	}

	public List<Billofmaterial> getBillofmaterials1() {
		return this.billofmaterials1;
	}

	public List<Billofmaterial> getBillofmaterials2() {
		return this.billofmaterials2;
	}

	public String getClass_() {
		return this.class_;
	}

	public String getColor() {
		return this.color;
	}

	public Integer getDaystomanufacture() {
		return this.daystomanufacture;
	}

	public Timestamp getDiscontinueddate() {
		return this.discontinueddate;
	}

	public String getFinishedgoodsflag() {
		return this.finishedgoodsflag;
	}

	public BigDecimal getListprice() {
		return this.listprice;
	}

	public String getMakeflag() {
		return this.makeflag;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public List<Productcosthistory> getProductcosthistories() {
		return this.productcosthistories;
	}

	public List<Productdocument> getProductdocuments() {
		return this.productdocuments;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public List<Productinventory> getProductinventories() {
		return this.productinventories;
	}

	public String getProductline() {
		return this.productline;
	}

	public List<Productlistpricehistory> getProductlistpricehistories() {
		return this.productlistpricehistories;
	}

	public Productmodel getProductmodel() {
		return this.productmodel;
	}

	public String getProductnumber() {
		return this.productnumber;
	}

	public List<Productproductphoto> getProductproductphotos() {
		return this.productproductphotos;
	}

	public List<Productreview> getProductreviews() {
		return this.productreviews;
	}

	public Productsubcategory getProductsubcategory() {
		return this.productsubcategory;
	}

	public Integer getReorderpoint() {
		return this.reorderpoint;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Integer getSafetystocklevel() {
		return this.safetystocklevel;
	}

	public Timestamp getSellenddate() {
		return this.sellenddate;
	}

	public Timestamp getSellstartdate() {
		return this.sellstartdate;
	}

	public String getSize() {
		return this.size;
	}

	public BigDecimal getStandardcost() {
		return this.standardcost;
	}

	public String getStyle() {
		return this.style;
	}

	public List<Transactionhistory> getTransactionhistories() {
		return this.transactionhistories;
	}

	public Unitmeasure getUnitmeasure1() {
		return this.unitmeasure1;
	}

	public Unitmeasure getUnitmeasure2() {
		return this.unitmeasure2;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public List<Workorder> getWorkorders() {
		return this.workorders;
	}

	public Billofmaterial removeBillofmaterials1(Billofmaterial billofmaterials1) {
		getBillofmaterials1().remove(billofmaterials1);
		billofmaterials1.setProduct1(null);

		return billofmaterials1;
	}

	public Billofmaterial removeBillofmaterials2(Billofmaterial billofmaterials2) {
		getBillofmaterials2().remove(billofmaterials2);
		billofmaterials2.setProduct2(null);

		return billofmaterials2;
	}

	public Productcosthistory removeProductcosthistory(Productcosthistory productcosthistory) {
		getProductcosthistories().remove(productcosthistory);
		productcosthistory.setProduct(null);

		return productcosthistory;
	}

	public Productdocument removeProductdocument(Productdocument productdocument) {
		getProductdocuments().remove(productdocument);
		productdocument.setProduct(null);

		return productdocument;
	}

	public Productinventory removeProductinventory(Productinventory productinventory) {
		getProductinventories().remove(productinventory);
		productinventory.setProduct(null);

		return productinventory;
	}

	public Productlistpricehistory removeProductlistpricehistory(Productlistpricehistory productlistpricehistory) {
		getProductlistpricehistories().remove(productlistpricehistory);
		productlistpricehistory.setProduct(null);

		return productlistpricehistory;
	}

	public Productproductphoto removeProductproductphoto(Productproductphoto productproductphoto) {
		getProductproductphotos().remove(productproductphoto);
		productproductphoto.setProduct(null);

		return productproductphoto;
	}

	public Productreview removeProductreview(Productreview productreview) {
		getProductreviews().remove(productreview);
		productreview.setProduct(null);

		return productreview;
	}

	public Transactionhistory removeTransactionhistory(Transactionhistory transactionhistory) {
		getTransactionhistories().remove(transactionhistory);
		transactionhistory.setProduct(null);

		return transactionhistory;
	}

	public Workorder removeWorkorder(Workorder workorder) {
		getWorkorders().remove(workorder);
		workorder.setProduct(null);

		return workorder;
	}

	public void setBillofmaterials1(List<Billofmaterial> billofmaterials1) {
		this.billofmaterials1 = billofmaterials1;
	}

	public void setBillofmaterials2(List<Billofmaterial> billofmaterials2) {
		this.billofmaterials2 = billofmaterials2;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDaystomanufacture(Integer daystomanufacture) {
		this.daystomanufacture = daystomanufacture;
	}

	public void setDiscontinueddate(Timestamp discontinueddate) {
		this.discontinueddate = discontinueddate;
	}

	public void setFinishedgoodsflag(String finishedgoodsflag) {
		this.finishedgoodsflag = finishedgoodsflag;
	}

	public void setListprice(BigDecimal listprice) {
		this.listprice = listprice;
	}

	public void setMakeflag(String makeflag) {
		this.makeflag = makeflag;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductcosthistories(List<Productcosthistory> productcosthistories) {
		this.productcosthistories = productcosthistories;
	}

	public void setProductdocuments(List<Productdocument> productdocuments) {
		this.productdocuments = productdocuments;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public void setProductinventories(List<Productinventory> productinventories) {
		this.productinventories = productinventories;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public void setProductlistpricehistories(List<Productlistpricehistory> productlistpricehistories) {
		this.productlistpricehistories = productlistpricehistories;
	}

	public void setProductmodel(Productmodel productmodel) {
		this.productmodel = productmodel;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public void setProductproductphotos(List<Productproductphoto> productproductphotos) {
		this.productproductphotos = productproductphotos;
	}

	public void setProductreviews(List<Productreview> productreviews) {
		this.productreviews = productreviews;
	}

	public void setProductsubcategory(Productsubcategory productsubcategory) {
		this.productsubcategory = productsubcategory;
	}

	public void setReorderpoint(Integer reorderpoint) {
		this.reorderpoint = reorderpoint;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSafetystocklevel(Integer safetystocklevel) {
		this.safetystocklevel = safetystocklevel;
	}

	public void setSellenddate(Timestamp sellenddate) {
		this.sellenddate = sellenddate;
	}

	public void setSellstartdate(Timestamp sellstartdate) {
		this.sellstartdate = sellstartdate;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setStandardcost(BigDecimal standardcost) {
		this.standardcost = standardcost;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setTransactionhistories(List<Transactionhistory> transactionhistories) {
		this.transactionhistories = transactionhistories;
	}

	public void setUnitmeasure1(Unitmeasure unitmeasure1) {
		this.unitmeasure1 = unitmeasure1;
	}

	public void setUnitmeasure2(Unitmeasure unitmeasure2) {
		this.unitmeasure2 = unitmeasure2;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public void setWorkorders(List<Workorder> workorders) {
		this.workorders = workorders;
	}

}