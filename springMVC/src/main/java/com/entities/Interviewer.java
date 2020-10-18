package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.Nullable;

@Entity
public class Interviewer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String designation;
	
	private int phone_no;
	
	@OneToMany(mappedBy = "interviewer",fetch = FetchType.EAGER)
	@Nullable
	private  List<JobApplication> job_application=new ArrayList<JobApplication>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}

	public List<JobApplication> getJob_application() {
		return job_application;
	}

	public void setJob_application(List<JobApplication> job_application) {
		this.job_application = job_application;
	}

	@Override
	public String toString() {
		return "Interviewer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", designation=" + designation + ", phone_no=" + phone_no + "]";
	}

	

	
	
	
}
