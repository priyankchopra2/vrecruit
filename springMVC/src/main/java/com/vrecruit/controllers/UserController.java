package com.vrecruit.controllers;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entities.User;
import com.exception.UserExistsException;
import com.exception.UserLoginException;
import com.service.UserService;

import org.apache.log4j.Logger;


@Controller
@SessionAttributes("usersession")
public class UserController {
	 private static final Logger logger = Logger.getLogger(UserController.class);
		
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		return mav;

	}

	@GetMapping("/list")
	public String listUser(Model theModel) {
		List<User> users = userService.getUsers();
		theModel.addAttribute("user", users);
		return "listusers";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid @ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {

			mav.setViewName("userregistration");
			// form validation error
			return mav;
		}
		mav.setViewName("userpage");
		if(userService.checkuser(user.getEmail()))
		{
			  userService.saveCustomer(user);
			  mav.addObject("user", user);
			  mav.addObject("usersession", user);
			  HttpSession session = request.getSession();
			   session.setAttribute("id",user.getId());
			
		    	
		}
		else
		{
			throw new UserExistsException("User exists....");
		}
     	
   	return mav;

	}
	@ExceptionHandler({UserExistsException.class})
	   public ModelAndView handleException(UserExistsException e) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("usererror");
		mav.addObject("errormsg",e.getUserException());
	      return mav;
	}

	@RequestMapping(value = "/userregistration", method = RequestMethod.GET)
	public ModelAndView showLogin(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("userregistration");

		mav.addObject("user", new User());

		return mav;

	}

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public ModelAndView showLoginform(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("candidatelogin");

		mav.addObject("user", user);

		return mav;

	}

	@RequestMapping(value = "/userpage", method = RequestMethod.GET)
	public ModelAndView showUserPage(@ModelAttribute("usersession") User user) {
		ModelAndView mav = new ModelAndView("userpage");
		mav.addObject("usersession", user);

		return mav;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public ModelAndView authenticate(@ModelAttribute("user") User user,HttpServletRequest request) throws Exception  {
		String email = user.getEmail();
		String password = user.getPassword();
		User users = userService.validate(email, password);
		if (users != null) {

			ModelAndView mav = new ModelAndView("userpage");
			mav.addObject("usersession", users);
			 HttpSession session = request.getSession();
			   session.setAttribute("id",users.getId());
			   logger.info("user login successful!");
				
				return mav;

		} else {
			throw new UserLoginException("Login not successful..");
		}
		//return null;
	}
	@ExceptionHandler({UserLoginException.class})
	   public ModelAndView handleException(UserLoginException e) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("usererror");
		mav.addObject("errormsg",e.getUserException());
	      return mav;
	}
	@RequestMapping(value = "/viewprofile")
	public ModelAndView viewprofile(@ModelAttribute("usersession") User user) {
		ModelAndView mav = new ModelAndView("profile");
		return mav;
	}

	@RequestMapping(value = "/editprofile")
	public ModelAndView editprofile(@ModelAttribute("usersession") User user) {
		ModelAndView mav = new ModelAndView("editprofile");
		mav.addObject("usersession", user);
		return mav;
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public ModelAndView updateUser(@Valid @ModelAttribute("usersession") User user, BindingResult result,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		int id = (int) session.getAttribute("id");

		user = userService.viewprofile(id);
		if (result.hasErrors()) {
			
			mav.setViewName("editprofile");
			// form validation error
			return mav;
		}
		userService.saveCustomer(user);
		
		mav.setViewName("message");
		String msg="Edited successfully!!";
		mav.addObject("msg", msg);
		
		mav.addObject("usersession", user);
		return mav;

	}

}
