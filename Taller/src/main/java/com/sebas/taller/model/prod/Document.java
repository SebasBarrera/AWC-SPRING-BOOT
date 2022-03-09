package com.sebas.taller.model.prod;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the document database table.
 *
 */
@Entity
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DOCUMENT_DOCUMENTNODE_GENERATOR", allocationSize = 1, sequenceName = "DOCUMENT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_DOCUMENTNODE_GENERATOR")
	private String documentnode;

	private Integer changenumber;

	private byte[] document;

	private String documentsummary;

	private String fileextension;

	private String filename;

	private String folderflag;

	private Timestamp modifieddate;

	private Integer owner;

	private String revision;

	private Integer rowguid;

	private Integer status;

	private String title;

	// bi-directional many-to-one association to Productdocument
	@OneToMany(mappedBy = "document")
	private List<Productdocument> productdocuments;

	public Document() {
	}

	public Productdocument addProductdocument(Productdocument productdocument) {
		getProductdocuments().add(productdocument);
		productdocument.setDocument(this);

		return productdocument;
	}

	public Integer getChangenumber() {
		return this.changenumber;
	}

	public byte[] getDocument() {
		return this.document;
	}

	public String getDocumentnode() {
		return this.documentnode;
	}

	public String getDocumentsummary() {
		return this.documentsummary;
	}

	public String getFileextension() {
		return this.fileextension;
	}

	public String getFilename() {
		return this.filename;
	}

	public String getFolderflag() {
		return this.folderflag;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Integer getOwner() {
		return this.owner;
	}

	public List<Productdocument> getProductdocuments() {
		return this.productdocuments;
	}

	public String getRevision() {
		return this.revision;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public Integer getStatus() {
		return this.status;
	}

	public String getTitle() {
		return this.title;
	}

	public Productdocument removeProductdocument(Productdocument productdocument) {
		getProductdocuments().remove(productdocument);
		productdocument.setDocument(null);

		return productdocument;
	}

	public void setChangenumber(Integer changenumber) {
		this.changenumber = changenumber;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public void setDocumentnode(String documentnode) {
		this.documentnode = documentnode;
	}

	public void setDocumentsummary(String documentsummary) {
		this.documentsummary = documentsummary;
	}

	public void setFileextension(String fileextension) {
		this.fileextension = fileextension;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFolderflag(String folderflag) {
		this.folderflag = folderflag;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public void setProductdocuments(List<Productdocument> productdocuments) {
		this.productdocuments = productdocuments;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}