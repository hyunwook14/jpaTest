package com.java.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name= "SAMPLE_TABLE")
public class SampleTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String smpleName;
	private String code;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSmpleName() {
		return smpleName;
	}
	public void setSmpleName(String smpleName) {
		this.smpleName = smpleName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
