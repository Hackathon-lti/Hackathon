package com.lti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.exception.CustomException;
import com.lti.model.User;
import com.lti.service.IUserService;

@Controller
public class UserController {
	@Autowired
	//@Qualifier(value="userService")
	private IUserService iUserService;
	
	public void setUserService(IUserService us) {
		this.iUserService = us;}

	@RequestMapping(value="/registration")
	public String gotoUserpage(Model model) {
	model.addAttribute("register1",new User());
		return "SignUp";
	}
	// For add and update person both
	@RequestMapping(value = "/add", 
			method = RequestMethod.POST)
	//@ExceptionHandler({ CustomException.class })
	public String addUser(
			@ModelAttribute("register1") 
			@Valid User u, 
			Model model,Map model1) {
		
				this.iUserService.addUser(u);
				// new user, add it
				model1.put("Alert","Thank you for registration");
			
				return "Studentdashboard";
				// existing user, call update
				//this.userService.updateUser(u);
}
	@RequestMapping("/Login")
	public String showLoginView(Model modal)
	{		
		modal.addAttribute("authuser", new User());
		
		return "Loginuser";
	}
	@RequestMapping(value="/Verification")
	public String LoginValidation(Model model,@Valid User u,HttpServletRequest req,HttpSession session)
	{
		/*if(u.getUserEmail().equalsIgnoreCase("Admin@gmail.com")&&u.getPassword().equalsIgnoreCase("admin123")) {
			session.setAttribute("adminuser",u.getUserEmail());
			session.setAttribute("adminpassword", u.getPassword());
			return "Addques";
			
		}*/


		String username=req.getParameter("userName");
		String password=req.getParameter("password");
	
		if(iUserService.verifyUser(username, password))
		{
			System.out.println("this is password"+password);
		return "Studentdashboard";
		}
		
		return "Loginuser";}

	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session ) {
	    session.invalidate();
	    return "redirect:/Login";
	} 
	
	@RequestMapping("/post")
	public String post(HttpSession session ) {
	    
	    return "post";
	} 
	
	@RequestMapping("/about")
	public String about(HttpSession session ) {
	    
	    return "about";
	} 
	
	@RequestMapping("/contact")
	public String contact(HttpSession session ) {
	    
	    return "contact";
	} 
	
	
	
	
	
	
	
	
	
	
}

	

	

	
