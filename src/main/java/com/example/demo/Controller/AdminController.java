package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.UserDetails;
import com.example.demo.repository.MatchRepo;
import com.example.demo.repository.TeamRepo;
import com.example.demo.repository.TournamentRepo;
import com.example.demo.repository.User_repository;
import com.example.demo.service.ServiceCric;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private User_repository repo;
	
	@Autowired
	private TeamRepo teamrepo;
	
	@Autowired
	private TournamentRepo tourRepo;
	
	@Autowired
	private MatchRepo matchrepo;
	

	@Autowired
	private ServiceCric service;
	@GetMapping("/admin")
	public String addusers(Model m) {
		List<UserDetails> user=repo.findAll();
		m.addAttribute("user", user);
		Long countusers=repo.count();
		m.addAttribute("countusers", countusers);
		m.addAttribute("teamrepo", teamrepo.count());
		m.addAttribute("tourRepo", tourRepo.count());
		m.addAttribute("matchrepo", matchrepo.count());
		
		return "admin_dashboard";
	}
	
	@GetMapping("/adminProfile")
	public ModelAndView profile(HttpSession session) {
		UserDetails user=service.findUserByEmail(session.getAttribute("user_email").toString());
		ModelAndView model=new ModelAndView("adminProfile");
		model.addObject("user", user);
		System.out.print(session.getAttribute("user_email").toString());
		return model;
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/deleteAdmin")
	public String deleteAdmin(HttpSession session) {
		service.deleteUser(session.getAttribute("user_email").toString());
		
		return "error";
	}
	
	@GetMapping("/userManage")
	public String getUsers(Model model) {
	    List<UserDetails> userList =repo.findAll();
	    model.addAttribute("user", userList);
	    return "userManage";
	}
	@PostMapping("/deleteuser")
	public String deleteuser(@ModelAttribute("userId") Long id) {
		repo.deleteById(id);
		return "redirect:/userManage";
	}


}
