package co.edu.icesi.dev.uccareapp.transport.model.prod;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the productreview database table.
 *
 */
@Entity
@NamedQuery(name = "Productreview.findAll", query = "SELECT p FROM Productreview p")
public class Productreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCTREVIEW_PRODUCTREVIEWID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTREVIEW_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTREVIEW_PRODUCTREVIEWID_GENERATOR")
	private Integer productreviewid;

	private String comments;

	private String emailaddress;

	private Timestamp modifieddate;

	private Integer rating;

	private Timestamp reviewdate;

	private String reviewername;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;

	public Productreview() {
	}

	public String getComments() {
		return this.comments;
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Product getProduct() {
		return this.product;
	}

	public Integer getProductreviewid() {
		return this.productreviewid;
	}

	public Integer getRating() {
		return this.rating;
	}

	public Timestamp getReviewdate() {
		return this.reviewdate;
	}

	public String getReviewername() {
		return this.reviewername;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductreviewid(Integer productreviewid) {
		this.productreviewid = productreviewid;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setReviewdate(Timestamp reviewdate) {
		this.reviewdate = reviewdate;
	}

	public void setReviewername(String reviewername) {
		this.reviewername = reviewername;
	}

}