package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Matches;
import com.example.demo.entity.Tournaments;
import com.example.demo.repository.MatchRepo;
import com.example.demo.repository.TournamentRepo;
import com.example.demo.service.MatchService;

@Controller
public class MatchController {
	@Autowired
	private TournamentRepo tr;
	
	@Autowired
	private MatchService service;
	
	@Autowired 
	private MatchRepo repo;
	
	
	@RequestMapping(value="/matches", method = RequestMethod.GET)
	public String match(@ModelAttribute Matches match,Model m) {
		List<Tournaments> tour=tr.findAll();
		m.addAttribute("tour", tour);
		String mt=match.getName();
		if(mt!=null ) {
			service.addMatches(match);
			boolean added=true; m.addAttribute("added",added);
			return "matches";
		}
		
		return "matches";

	}

}
