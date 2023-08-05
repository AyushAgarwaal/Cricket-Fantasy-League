package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Selection;
import com.example.demo.repository.SelectionRepo;

import jakarta.transaction.Transactional;

@Service
public class SelectionService {
	
	@Autowired
	private SelectionRepo repo;

	 public void addUserSelection(Selection s) {
		 repo.save(s);
	 }

	public List<Long> findTeamByIdEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findTeamByIdEmail(email);
	}

	@Transactional
	public void updateStatus(Long team,String status) {
		// TODO Auto-generated method stub
		repo.updateStatus(team,status);
	}

	public Long findId(String email,Long team) {
		// TODO Auto-generated method stub
		return repo.findId(email,team);
	}

	public String findStatus(Long id) {
		// TODO Auto-generated method stub
		return repo.findStatus(id);
	}

	public List<String> findemail(Long team) {
		 // TODO Auto-generated method stub
		 return repo.findemail(team);
			}
	

		
		/*
		 * public String getWalletDetails(String email) { return repo.getWalletDetails(
		 * email); }
		 */


}
