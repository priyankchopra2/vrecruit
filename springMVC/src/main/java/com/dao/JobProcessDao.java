package com.dao;

import java.util.List;

import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.entities.User;

//import com.project.recruitmentoperation.entity.JobApplication;
//import com.project.recruitmentoperation.entity.JobProcessDetails;
//import com.project.recruitmentoperation.entity.User;

public interface JobProcessDao {
	
	  public void save(JobProcessDetails uploadFile);

	public boolean validate(User user);

	public JobApplication getJob(int id);
	
	public List<JobProcessDetails> getCandidatesJobProcess(int id);
	
	public List<JobProcessDetails> update(JobProcessDetails obj);
	
	public JobProcessDetails findById(int id);

}
