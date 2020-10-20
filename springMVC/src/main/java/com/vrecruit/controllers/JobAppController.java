package com.vrecruit.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.InterviewerDAO;
import com.dao.JobAppDAO;
import com.entities.Interviewer;
import com.entities.JobApplication;

@RequestMapping("/jobApp")
@Controller
public class JobAppController {

	@Autowired
	JobAppDAO jobAppDao;

	@Autowired
	InterviewerDAO interviewerDao;

	List<JobApplication> lst;

	List<String> categories = Arrays.asList("HR", "IT", "FINANCE");

	@RequestMapping("/create")
	public ModelAndView create(ModelAndView m) {
		m.setViewName("createJobApplication");
		m.addObject("jobApp", new JobApplication());
		m.addObject("categories", categories);
		return m;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("jobApp") JobApplication jobApp, BindingResult br,
			HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("interviewerId");
//		|| categories.contains(jobApp.getCategory())
		  if (br.hasErrors() ) {  
				m.setViewName("createJobApplication");
	        }  
	        else {  
	        	jobApp.setInterviewer(interviewerDao.findById(id));
	        	
				m.setViewName("JobApplicationList");
		//    	Setting object from form to db
				jobAppDao.save(jobApp);
		
		//    	Getting list of interviewer from database
				lst = jobAppDao.getAll();
		
				m.addObject("lst", lst);
	        }  
		
		return m;
	}

	// This will get and display all the data of job applications which are there
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public ModelAndView show() {
		ModelAndView m = new ModelAndView();

		m.setViewName("JobApplicationList");

//    	Getting list of interviewer from database
		lst = jobAppDao.getAll();

		m.addObject("lst", lst);

		return m;
	}

	// This will get and display all the data of job applications which are there
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView show(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();

		m.setViewName("JobApplicationList");

		HttpSession session = request.getSession();

		int id = (int) session.getAttribute("interviewerId");
		System.out.println("id get while fetching for list of JA:  " + id);
//    	Getting list of interviewer from database
		lst = jobAppDao.findByInterviewerId(id);

		m.addObject("lst", lst);

		return m;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id) {
//		System.out.println("This is the id which im getting "+id);
		ModelAndView m = new ModelAndView();
		JobApplication job = new JobApplication();
		for (JobApplication i : lst) {
			if (i.getJid() == id) {
				job = i;
			}
		}
		m.addObject("categories", categories);
		m.setViewName("EditJobApp");
		m.addObject("jobApp", job);
		return m;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("jobApp") JobApplication job, BindingResult bindingResult) {
		ModelAndView m = new ModelAndView();

		m.setViewName("JobApplicationList");
		System.out.println(job);
		// update function will return the updated list
		lst = jobAppDao.update(job);

		m.addObject("lst", lst);

		return m;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView m = new ModelAndView();
		m.setViewName("JobApplicationList");
		for (JobApplication i : lst) {
			if (i.getJid() == id) {
				jobAppDao.delete(i);
				break;
			}
		}
		lst = jobAppDao.getAll();
		m.addObject("lst", lst);
		return m;
	}
	
	
	
	
//	CANDIDATE PART
	@RequestMapping(value = "/candidateJobAppList", method = RequestMethod.GET)
	public ModelAndView candidateJobAppList() {
		ModelAndView m = new ModelAndView();

		m.setViewName("CandidateJobApplicationList");

//    	Getting list of interviewer from database
		lst = jobAppDao.getAll();

		m.addObject("lst", lst);

		return m;
	}

}
//org.springframework.beans.factory.CannotLoadBeanClassException: Error loading class [org.springframework.validation.beanvalidation.LocalValidatorFactoryBean] for bean with name 'myBeansValidator' defined in ServletContext resource [/WEB-INF/frontController-servlet.xml]: problem with class file or dependent class; nested exception is java.lang.NoClassDefFoundError: javax/validation/ValidatorFactory
