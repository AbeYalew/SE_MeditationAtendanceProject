package edu.mum.cs.projects.attendance.domain.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Setup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String version;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	} 
	
	

}
