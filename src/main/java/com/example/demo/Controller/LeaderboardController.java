package com.example.demo.Controller;
import java.util.function.*;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Leaderboard;
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

import com.example.demo.service.LeaderboardService;
import com.example.demo.service.MatchService;
import com.example.demo.service.SelectionService;
import com.example.demo.service.ServiceCric;
import com.example.demo.service.TeamService;
import com.example.demo.service.TourService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LeaderboardController {

	@Autowired
	private User_repository repouser;
	@Autowired
	private ServiceCric userService;
	
	@Autowired
	private ServiceCric user;
	@Autowired
	private TeamRepo tmrepo;
	
	@Autowired
	private MatchRepo mrepo;
	
	@Autowired
	private TournamentRepo toRepo;
	
	@Autowired
	private MatchService mservice;
	
	@Autowired
	private TeamService teamservice;
	
	@Autowired
	private LeaderboardService service;
	
	
	@Autowired
	private SelectionRepo srepo;

	@Autowired
	private SelectionRepo repo;
	
	
	@Autowired
	private TourService tourservice;
	
	

	
	
	
	private Selection select=new Selection();
	
	@Autowired
	private SelectionService ss;
	
	 @GetMapping("/winning")
	 public String winteam(@RequestParam("team")Long team,HttpSession session) {
		 Long match=teamservice.findmatch(team);
		 Long tournament=mservice.findtour(match);
		 System.out.println("team is:"+tmrepo.findById(team).get().getName());
		 System.out.println("match is:"+mrepo.findById(match).get().getName());
		 System.out.println("tournament is: "+ toRepo.findById(tournament).get().getName());
		 ss.updateStatus(team,"Won");
		 List<String>emails=ss.findemail(team);
		 for(int i=0;i<emails.size();i++) {
		 user.updateWallet(emails.get(i),user.getwalletBalance(emails.get(i)) +400l);
		 Long winningprize=user.getWinningprize(emails.get(i));
		 user.updateWinningprize(session.getAttribute("user_email").toString(),winningprize+400);
		 }
		 Long loose=teamservice.findlose(match,team);
		 System.out.println(loose);
		 ss.updateStatus(loose, "Lost");
		// System.out.println("winning......."+winningprize);
		 return "redirect:/admin";}

	
	@GetMapping("/teamwinning")
	public String handleUserSelection(@RequestParam(value = "tournament", required = false) String tournament,
			@ModelAttribute Tournaments tr, Model m,HttpSession session ,@ModelAttribute Selection select) {
		List<Tournaments> tour = toRepo.findAll();
		m.addAttribute("tour", tour);
        System.out.println("Hi tournament  "+ tournament);
	 return "teamwinning";  }
	
	
	
	
	  @GetMapping("/result") public String result(HttpSession session,Model model) {
	  List<Long> teamSelect=ss.findTeamByIdEmail(session.getAttribute("user_email").toString());
	 
	 List< List<String>> resfinal=new LinkedList<>();
	  for(int i=0;i<teamSelect.size();i++)
	  { 
		  List<String> res=new LinkedList<>();
		  Long id=ss.findId(session.getAttribute("user_email").toString(),teamSelect.get(i)); String
	  tournament=tourservice.findtour(teamservice.findmatch(teamSelect.get(i)));
	  String
	  matchname=mservice.findMatchname(teamservice.findmatch(teamSelect.get(i)));
	  String teamname=teamservice.findteamname(teamSelect.get(i)); 
	  String status=ss.findStatus(id); 
	  res.add(matchname);
	  res.add(teamname);
	  res.add(status);
	  resfinal.add(res);
	  }
	  System.out.println("List......"+resfinal);
	  model.addAttribute("select", resfinal);	  
	  return "result"; }
	  
	  
	  
	  
	  @GetMapping("/leaderboard")
	  public String lead(Model model) {
		 List<UserDetails> user=userService.orderByWin();
		  model.addAttribute("user", user);
		  System.out.println(user);
		  return "leaderboard";
	  }
	 
}

		 
	
	
	 
