package com.sebas.taller.model.prod;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the productphoto database table.
 * 
 */
@Entity
@NamedQuery(name="Productphoto.findAll", query="SELECT p FROM Productphoto p")
public class Productphoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCTPHOTO_PRODUCTPHOTOID_GENERATOR",allocationSize = 1, sequenceName="PRODUCTPHOTO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTPHOTO_PRODUCTPHOTOID_GENERATOR")
	private Integer productphotoid;

	private byte[] largephoto;

	private String largephotofilename;

	private Timestamp modifieddate;

	private byte[] thumbnailphoto;

	private String thumbnailphotofilename;

	//bi-directional many-to-one association to Productproductphoto
	@OneToMany(mappedBy="productphoto")
	private List<Productproductphoto> productproductphotos;

	public Productphoto() {
	}

	public Integer getProductphotoid() {
		return this.productphotoid;
	}

	public void setProductphotoid(Integer productphotoid) {
		this.productphotoid = productphotoid;
	}

	public byte[] getLargephoto() {
		return this.largephoto;
	}

	public void setLargephoto(byte[] largephoto) {
		this.largephoto = largephoto;
	}

	public String getLargephotofilename() {
		return this.largephotofilename;
	}

	public void setLargephotofilename(String largephotofilename) {
		this.largephotofilename = largephotofilename;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public byte[] getThumbnailphoto() {
		return this.thumbnailphoto;
	}

	public void setThumbnailphoto(byte[] thumbnailphoto) {
		this.thumbnailphoto = thumbnailphoto;
	}

	public String getThumbnailphotofilename() {
		return this.thumbnailphotofilename;
	}

	public void setThumbnailphotofilename(String thumbnailphotofilename) {
		this.thumbnailphotofilename = thumbnailphotofilename;
	}

	public List<Productproductphoto> getProductproductphotos() {
		return this.productproductphotos;
	}

	public void setProductproductphotos(List<Productproductphoto> productproductphotos) {
		this.productproductphotos = productproductphotos;
	}

	public Productproductphoto addProductproductphoto(Productproductphoto productproductphoto) {
		getProductproductphotos().add(productproductphoto);
		productproductphoto.setProductphoto(this);

		return productproductphoto;
	}

	public Productproductphoto removeProductproductphoto(Productproductphoto productproductphoto) {
		getProductproductphotos().remove(productproductphoto);
		productproductphoto.setProductphoto(null);

		return productproductphoto;
	}

}