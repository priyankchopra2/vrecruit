package com.service;

import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.entities.User;

//import com.project.recruitmentoperation.entity.JobApplication;
//import com.project.recruitmentoperation.entity.JobProcessDetails;
//import com.project.recruitmentoperation.entity.User;

public interface JobProcessService {
	
	public void	save (JobProcessDetails upload);

	public boolean validate(User user);

	public JobApplication getJob(int id);
	 

}
