package com.wingbels.belssagecore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bcdocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iddocument;
	private String fileName;
	private String fileType;
	private String path;
	@ManyToOne
	private Bcemployees employee;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getIddocument() {
		return iddocument;
	}

	public void setIddocument(Long iddocument) {
		this.iddocument = iddocument;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Bcemployees getEmployee() {
		return employee;
	}

	public void setEmployee(Bcemployees employee) {
		this.employee = employee;
	}

}
