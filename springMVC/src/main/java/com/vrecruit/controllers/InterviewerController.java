package com.vrecruit.controllers;

import java.util.*;
import java.util.stream.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.InterviewerDAO;
import com.entities.Interviewer;

@Controller
public class InterviewerController {

	@Autowired
	InterviewerDAO interviewerDao;

	List<Interviewer> lst;

	@RequestMapping("/create")
	public ModelAndView create(ModelAndView m) {
		m.setViewName("createInterviewer");
		m.addObject("interviewer", new Interviewer());
		return m;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("interviewer") Interviewer obj, BindingResult br) {
		ModelAndView m = new ModelAndView();

		m.setViewName("InterviewerList");
//    	Setting object from form to db
		interviewerDao.save(obj);

//    	Getting list of interviewer from database
		lst = interviewerDao.getAll();

		m.addObject("lst", lst);

		return m;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView show(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("interviewerId")==null) {
			//can throw exception here or return to home page
			m.setViewName("login");
		}
		else {
			m.setViewName("interviewerDashboard");
		}
		
		return m;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView m = new ModelAndView();

		m.setViewName("login");

//    	Getting list of interviewer from database
		lst = interviewerDao.getAll();

		lst.stream().forEach(System.out::println);

		return m;
	}
	
	@RequestMapping(value = "/ilogout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		m.setViewName("login");
		return m;
	}

	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public ModelAndView loginAction(@RequestParam String email,@RequestParam String password,HttpServletRequest request) {
		ModelAndView m = new ModelAndView();

		lst = interviewerDao.getAll();
		Interviewer res=new Interviewer();
		List s= lst.stream().filter(e->e.getEmail().equals(email)).collect(Collectors.toList());
		
		for(Object o:s) {
			System.out.println(o);
			res=(Interviewer) o;
		}
		
		
		if(res.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("interviewerId", res.getId());
			session.setAttribute("interviewerName", res.getName());
			m.addObject("id",res.getId());
			m.addObject("name",res.getName());
			m.setViewName("interviewerDashboard");
		}
		else {
			m.setViewName("login");
		}
		
		m.addObject("lst", lst);

		return m;
	}

}
