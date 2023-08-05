package com.example.demo.Controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthenticatedUser;
import com.example.demo.entity.Matches;
import com.example.demo.entity.Selection;
import com.example.demo.entity.Teams;
import com.example.demo.entity.Tournaments;
import com.example.demo.entity.UserDetails;
import com.example.demo.repository.MatchRepo;
import com.example.demo.repository.SelectionRepo;
import com.example.demo.repository.TeamRepo;
import com.example.demo.repository.TournamentRepo;
import com.example.demo.repository.User_repository;
import com.example.demo.service.MatchService;
import com.example.demo.service.SelectionService;
import com.example.demo.service.ServiceCric;
import com.example.demo.service.TeamService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	UserDetails u;
	AuthenticatedUser auth = new AuthenticatedUser();
	@Autowired
	private SelectionService service;

	@Autowired
	private TournamentRepo toRepo;

	@Autowired
	ServiceCric serviceCric;

	static boolean flag;

	@GetMapping("/userSelection")
	public String handleUserSelection(@RequestParam(value = "tournament", required = false) String tournament,
			@ModelAttribute Tournaments tr, Model m, HttpSession session, @ModelAttribute Selection select) {
		List<Tournaments> tour = toRepo.findAll();
		m.addAttribute("tour", tour);
		System.out.println("HI tournament  " + tournament);

		if (select.getTeam() != null) {
			select.setStatus("pending");
			System.out.println(select.getTeam());
			service.updateStatus(select.getTeam(), "pending");
			String userName = session.getAttribute("user_email").toString();
			System.out.print("hii: " + session.getAttribute("user_email"));
			Long currentBalance = serviceCric.getwalletBalance(userName);
			Long updatedBalance = currentBalance - 200;
			serviceCric.updateWallet(userName, updatedBalance);

			select.setUseremail(session.getAttribute("user_email").toString());
			service.addUserSelection(select);
			System.out.println("khx" + select.getTeam());
			return "redirect:/user";
		}

		return "userSelection";
	}

	@GetMapping("/user")
	public String userinfo(HttpSession session, Model m) {
		Long wallet = serviceCric.getwalletBalance((String) session.getAttribute("user_email"));
		m.addAttribute("wallet", wallet);
		return "user";
	}

}
