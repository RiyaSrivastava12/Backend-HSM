package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class PatientHistory {
	
	//Fields
	@Id
	@GeneratedValue
	private int Id;
	@NotBlank(message="This is a required field.")
	private String disease;
	@NotBlank(message="This is a required field.")
	private String dAdvice;
	@NotBlank(message="This is a required field.")
	private String diet;
	
		public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
		public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getdAdvice() {
		return dAdvice;
	}
	public void setdAdvice(String dAdvice) {
		this.dAdvice = dAdvice;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	
	@Override
	public String toString() {
		return "PatientHistory [disease=" + disease + ", dAdvice=" + dAdvice + ", diet=" + diet  + "]";
	}
	
	

}
