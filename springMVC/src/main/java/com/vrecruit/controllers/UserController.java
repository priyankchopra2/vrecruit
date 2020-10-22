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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entities.User;
import com.service.UserService;



@Controller
@SessionAttributes("usersession")
public class UserController {

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
	public ModelAndView createUser(@Valid @ModelAttribute("user") User user, BindingResult result) throws Exception {
		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {

			mav.setViewName("userregistration");
			// form validation error
			return mav;
		}
		mav.setViewName("home");
		if(userService.checkuser(user.getEmail()))
		{
			  userService.saveCustomer(user);
			  mav.addObject("user", user);
		    	
		}
		else
		{
			throw new Exception("User exists..");
		}
     	
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

	public ModelAndView authenticate(@ModelAttribute("user") User user,HttpServletRequest request) throws Exception {
		String email = user.getEmail();
		String password = user.getPassword();
		User users = userService.validate(email, password);
		if (users != null) {

			ModelAndView mav = new ModelAndView("userpage");
			mav.addObject("usersession", users);
			 HttpSession session = request.getSession();
			   session.setAttribute("id",users.getId());
			  
				return mav;

		} else {
			throw new Exception("Login not successful..");
		}
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
	public ModelAndView updateUser(@Valid @ModelAttribute("usersession") User user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			 System.out.println("*");

			mav.setViewName("editprofile");
			// form validation error
			return mav;
		}
		userService.saveCustomer(user);
		mav.setViewName("userpage");

		mav.addObject("usersession", user);
		return mav;

	}

}
