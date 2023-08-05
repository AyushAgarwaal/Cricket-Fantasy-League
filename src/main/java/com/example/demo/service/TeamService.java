package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DynamicEntity;
import com.example.demo.entity.Teams;
import com.example.demo.repository.TeamRepo;

@Service
public class TeamService {
	@Autowired
	private TeamRepo repo;

	public List<DynamicEntity> findTeamById(Long id) {
		return repo.findTeamById(id);
	}

	public List<String> findteamname(Long id,Long tourid) {
		// TODO Auto-generated method stub
		return repo.findteamname(id,tourid);
	}

	public Long findmatch(Long team) {
		// TODO Auto-generated method stub
		return repo.findmatch(team);
	}

	public Long findlose(Long match, Long team) {
		// TODO Auto-generated method stub
		return repo.findlose(match,team);
	}

	public String findteamname(Long teamid) {
		// TODO Auto-generated method stub
		return repo.findteam(teamid);
	}


	

}
