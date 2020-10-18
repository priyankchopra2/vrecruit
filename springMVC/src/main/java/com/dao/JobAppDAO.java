package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Interviewer;
import com.entities.JobApplication;

@Component
public class JobAppDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int save(JobApplication obj) {
		Integer i=(Integer) this.hibernateTemplate.save(obj);
		return i;
	}
	
	public List<JobApplication> getAll(){
		
		List<JobApplication> jobApp = this.hibernateTemplate.loadAll(JobApplication.class);
		return jobApp;
	}
	
	public List<JobApplication> findByInterviewerId(int id){	
		List<JobApplication> jobApp = (List<JobApplication>) this.hibernateTemplate.
				find("from JobApplication j where j.interviewer.id = "+id);
		
		return jobApp;
	}
    		
	
	@Transactional
	public List<JobApplication> update(JobApplication obj){
		 this.hibernateTemplate.saveOrUpdate(obj); 
		 List<JobApplication> jobApp = this.hibernateTemplate.loadAll(JobApplication.class);
		 return jobApp;
	}
	
	@Transactional
	public void delete(JobApplication obj) {
		this.hibernateTemplate.delete(obj);
	}
	
	
	
}
