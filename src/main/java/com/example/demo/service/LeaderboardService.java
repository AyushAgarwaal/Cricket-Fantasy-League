package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Leaderboard;
import com.example.demo.repository.leaderboardRepo;

@Service
public class LeaderboardService {

	@Autowired
	private leaderboardRepo repo;
	
	public void addLeader(Leaderboard team) {
		repo.save(team);
	}
	
	
}
