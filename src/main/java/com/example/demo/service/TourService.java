package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TournamentRepo;

@Service
public class TourService {
	@Autowired
	private TournamentRepo repo;
	

	public String findtour(Long tourid) {
		// TODO Auto-generated method stub
		return repo.findtour(tourid);
	}

}
