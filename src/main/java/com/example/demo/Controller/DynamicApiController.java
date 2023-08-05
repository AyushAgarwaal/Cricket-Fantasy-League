package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthenticatedUser;
import com.example.demo.entity.DynamicEntity;
import com.example.demo.entity.Matches;
import com.example.demo.entity.Teams;
import com.example.demo.repository.MatchRepo;
import com.example.demo.service.MatchService;
import com.example.demo.service.TeamService;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@RestController
public class DynamicApiController {
	AuthenticatedUser auth=new AuthenticatedUser();
	
	@Autowired
	private MatchRepo repo;
	@Autowired
	private MatchService service;
	
	@Autowired
	private TeamService tmService;
	
	


	@GetMapping("/matchesByTournament")
	public List<DynamicEntity>  matchesByTournament(@RequestParam(value="tournament")Long tournament ,Matches mtch){
		System.out.print("HI       HI    "+tournament);
		List<DynamicEntity> matchT=service.findTourById(tournament);
		System.out.print(matchT);
		return matchT;
	}
	
	
	/*
	 * @GetMapping("/matchesOfTournament") public ResponseEntity
	 * matchesOfTournament(@RequestParam(value="tournament")Long tournament ,Matches
	 * mtch){ System.out.print("HI       HI    "+tournament); List<DynamicEntity>
	 * matchT=service.findMatchesOfTournament(tournament);
	 * System.out.print("its working "+matchT); return new ResponseEntity(matchT,
	 * HttpStatus.OK); }
	 */
	
	
	@GetMapping("/teamsByMatches")
	public List<DynamicEntity>  teamsByMatches(@RequestParam(value="match")Long match ,Teams t){
		System.out.print("HI       HI    "+match);
		List<DynamicEntity> teamT=tmService.findTeamById(match);
		System.out.print("hii "+teamT);
		
		return teamT;
	}
	/*
	 * @ModelAttribute("matchT") public List<String> listOfMatches
	 * (@RequestParam(value="tournament")Long tournament ,Matches mtch){ return
	 * matchesByTournament(tournament,mtch); }
	 */
}