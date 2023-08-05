package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ResultUser;
import com.example.demo.entity.UserDetails;
import com.example.demo.repository.User_repository;
import com.example.demo.service.ServiceCric;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileContoller {
	@Autowired
	User_repository repo;
	
	@Autowired
	ServiceCric service;
	
	@GetMapping("/userprofile")
	public ModelAndView getUserDetails(HttpSession session) {
	    UserDetails user= service.findUserByEmail((String)session.getAttribute("user_email"));
	    ModelAndView model=new ModelAndView("userprofile");
	    		model.addObject("user", user);
	    return model;
	}
	
	@GetMapping("/deleteUser")
	public String deleteuser(HttpSession session) {
		System.out.print("hi");
		service.deleteUser(session.getAttribute("user_email").toString());
		
		return "error";
	}
	
	@GetMapping("/edituser")
	public String edituser(Model m,@RequestParam("name") String name,@RequestParam("password") String password,HttpSession session) {
		System.out.print(name);
		if(name!=null) {
			service.updateName(session.getAttribute("user_email").toString(), name);
		}
		if(password!=null) {
			service.updatePassword(session.getAttribute("user_email").toString(), password);
		}
		/*
		 * List<UserDetails> user=repo.findAll(); m.addAttribute("user", user);
		 */
		System.out.println("hii");
		return "redirect:/index";
	}
	
	
}
