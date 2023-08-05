package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.AuthenticatedUser;
import com.example.demo.entity.UserDetails;
import com.example.demo.repository.User_repository;
import com.example.demo.service.ServiceCric;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.Session;

@Controller
public class ContollerClass {
	AuthenticatedUser auth = new AuthenticatedUser();

	@Autowired
	private ServiceCric service;

	@Autowired
	private JavaMailSender mailSender;

	private UserDetails u;

	/*
	 * public ContollerClass() { }
	 */
	// TODO Auto-generated constructor stub
	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new UserDetails());
		return "register";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	/*
	 * @GetMapping("/admin") public String admin() { return "admin_dashboard"; }
	 */

	@PostMapping("/index")
	public String index(@ModelAttribute UserDetails u, Model m, @RequestParam("user_email") String user_email,
			HttpSession session) {
		UserDetails user = service.findUserByEmail(u.getUser_email());
		String role = service.Getusertype(u.getUser_email());
		String password = service.Getuserpassword(u.getUser_email());
		if (user != null && password.equals(u.getPassword()) && role.equals("user")) {
			boolean usertype = true;
			m.addAttribute("usertype", usertype);
			session.setAttribute("user_email", user_email);
			System.out.print(session.getAttribute("user_email"));

			return "redirect:/user";
		}
		if (user != null && password.equals(u.getPassword()) && role.equals("admin")) {
			session.setAttribute("user_email", user_email);
			return "redirect:/admin";
		} else {
			boolean notregister = true;
			m.addAttribute("notregister", notregister);
			return "index";
		}
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") UserDetails u, BindingResult res, Model m) {

		System.out.println(u);
		UserDetails userexist = service.findUserByEmail(u.getUser_email());
		System.out.println(userexist);
		if (res.hasErrors()) {
			return "register";
		}
		if (userexist != null) {
			boolean exist = true;
			m.addAttribute("exist", exist);
			return "register";
		}
		service.addUser(u);
		boolean registrationSuccessfull = true;
		m.addAttribute("success", registrationSuccessfull);
		if (u.getUser_type().equals("user")) {
			u.setWallet(1000l);
			u.setWinningPrize(0l);

		} else {
			u.setWallet(null);
		}
		service.addUser(u);

		// Email Code
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("ayush.agarwal@credextechnology.com");
		message.setTo(u.getUser_email());
		message.setSubject("Registration successful");
		message.setText("Hello " + u.getUser_name() + ",\n\nYour registration for cricket fantasy league is successful."
				+ "Your login credentials are:\n\n Email:" + u.getUser_email() + "\nPassword: " + u.getPassword());
		mailSender.send(message);
		System.out.print("sentt!!!!!!!!");

		return "register";
	}

	@GetMapping("/terms")
	public String terms() {
		return "terms";
	}
}
