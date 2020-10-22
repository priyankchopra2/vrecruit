package com.vrecruit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dao.JobAppDAO;
import com.dao.JobProcessDaoImpl;
import com.entities.JobApplication;
import com.entities.JobProcessDetails;
import com.entities.User;
import com.service.JobProcessService;
import com.service.UserService;

@Controller
@SessionAttributes("job")
public class JobProcessController {
	@Autowired
	private JobProcessService JobApplicationService;
	@Autowired
	private UserService userService;
	@Autowired
	JobAppDAO jobAppDao;
	
	
	List<JobApplication> lst;
	JobProcessDetails job;
	JobApplication jobApplication;
	User user;
	

//		CANDIDATE PART
	@RequestMapping(value = "/candidateJobAppList", method = RequestMethod.GET)
	public ModelAndView candidateJobAppList(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();

		HttpSession session = request.getSession();

		int id = (int) session.getAttribute("id");

		user = userService.viewprofile(id);

//	    	Getting list of interviewer from database
		lst = jobAppDao.getAll();
		boolean jobs = JobApplicationService.validate(user);
		if (jobs) {
			m.setViewName("CandidateJobApplicationList");
			m.addObject("lst", lst);
			job = new JobProcessDetails();
			m.addObject("job", job);
		} else {
			m = status();

		}

		return m;
	}

	@RequestMapping(value = "/apply")
	public ModelAndView applyforjob(@RequestParam("id") int id, HttpServletRequest request) {
		JobApplication jobApplication = JobApplicationService.getJob(id);
		HttpSession session = request.getSession();
		session.setAttribute("jid", jobApplication.getJid());

		ModelAndView mav = new ModelAndView("CandidateJobApplication");
		return mav;

	}

	@RequestMapping(value = "/uploadresume", method = RequestMethod.POST)
	public ModelAndView handleFileUpload(@ModelAttribute("job") JobProcessDetails job, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();

		int jid = (int) session.getAttribute("jid");
		// save job ID
		jobApplication = JobApplicationService.getJob(jid);
		job.setJobApplication(jobApplication);
		// save User ID
		job.setUser(user);
		user.setJobProcessDetails(job);

		// Save Resume

		JobApplicationService.save(job);
		mav = status();

		return mav;
	}

	public ModelAndView status() {
		ModelAndView mav = new ModelAndView();
		String status;
		job = user.getJobProcessDetails();
		System.out.println(job.getJobid());
		mav.addObject("job", job);
		jobApplication = job.getJobApplication();
		mav.addObject("jobApplication", jobApplication);
		if (job.getSelected()) {
			if (jobApplication.getRounds() == job.getCurrentround()) {
				status = "Congrats!!!! You are selected for the applied position";
			} else {
				status = "Congrats!!!! You are selected for the next round";
			}
		} else if (job.getSelected() == false && job.getCurrentround() > 0) {
			status = "Better luck next time!!";
		} else {
			status = "Waiting for interview";
		}
		mav.addObject("status", status);

		mav.setViewName("status");
		return mav;
	}
	
	
	

}
