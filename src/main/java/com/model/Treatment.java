package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Treatment {
	
	//Fields
	@Id
	@GeneratedValue
	private int tid;
	@NotBlank(message="This is a required field.")
	private String reports;
	@NotBlank(message="This is a required field.")
	private String medicines;
	@NotBlank(message="This is a required field.")
	private String description;
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getReports() {
		return reports;
	}
	public void setReports(String reports) {
		this.reports = reports;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Treatment [tid=" + tid +  ", reports=" + reports
				+ ", medicines=" + medicines + ", description=" + description + "]";
	}
	
	
	
}
