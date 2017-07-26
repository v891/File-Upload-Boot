package com.fileuploader.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class DocumentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4362387357405111079L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date uploadDateTime;
	private String fileType;
	private byte[] fileData;
	private String fileName;

	public DocumentEntity() {
		super();
	}
	
	public DocumentEntity(byte[] fileData, String fileName, String fileType, Date uploadDateTime) {
		super();
		this.fileData = fileData;
		this.fileType = fileType;
		this.uploadDateTime = uploadDateTime;
		this.fileName = fileName;
	}

	public Long getId() {
		return id;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getUploadDateTime() {
		return uploadDateTime;
	}

	public void setUploadDateTime(Date uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
