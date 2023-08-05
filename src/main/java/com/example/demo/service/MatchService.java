package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DynamicEntity;
import com.example.demo.entity.Matches;
import com.example.demo.repository.MatchRepo;

@Service
public class MatchService {
 
	
	
	@Autowired
	private MatchRepo mr;
	public void addMatches(Matches match) {
		mr.save(match);
	}
	public List<DynamicEntity> findTourById(Long id) {
		return mr.findTourById(id);
	}
	
	/*
	 * public List<DynamicEntity> findMatchesOfTournament(Long id) { return
	 * mr.findMatchesOfTournament(id); }
	 */
	
	public String findEnteredMatch(String name) {
		// TODO Auto-generated method stub
		return mr.findEnteredMatch(name);
	}
	public List<String> findTourname(Long tourid) {
		return mr.findTourname(tourid);
		// TODO Auto-generated method stub
		
	}
	public Long findtour(Long match) {
		// TODO Auto-generated method stub
		return mr.findtour(match);
	}
	public String findMatchname(Long matchid) {
		// TODO Auto-generated method stub
		return mr.findMatchname(matchid);
	}
	
	 
}
