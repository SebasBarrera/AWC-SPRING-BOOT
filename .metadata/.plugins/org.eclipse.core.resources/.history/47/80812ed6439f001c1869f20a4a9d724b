package co.edu.icesi.dev.uccareapp.transport.model.prod;

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
 * The persistent class for the productsubcategory database table.
 *
 */
@Entity
@NamedQuery(name = "Productsubcategory.findAll", query = "SELECT p FROM Productsubcategory p")
public class Productsubcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTSUBCATEGORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID_GENERATOR")
	private Integer productsubcategoryid;

	private Timestamp modifieddate;

	private String name;

	private Integer rowguid;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "productsubcategory")
	private List<Product> products;

	// bi-directional many-to-one association to Productcategory
	@ManyToOne
	@JoinColumn(name = "productcategoryid")
	private Productcategory productcategory;

	public Productsubcategory() {
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductsubcategory(this);

		return product;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Productcategory getProductcategory() {
		return this.productcategory;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public Integer getProductsubcategoryid() {
		return this.productsubcategoryid;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductsubcategory(null);

		return product;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductcategory(Productcategory productcategory) {
		this.productcategory = productcategory;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setProductsubcategoryid(Integer productsubcategoryid) {
		this.productsubcategoryid = productsubcategoryid;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

}