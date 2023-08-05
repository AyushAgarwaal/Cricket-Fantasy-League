package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Teams;
import com.example.demo.entity.Tournaments;
import com.example.demo.entity.UserDetails;
import com.example.demo.repository.TeamRepo;
import com.example.demo.repository.TournamentRepo;
import com.example.demo.repository.User_repository;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
@Service
public class ServiceCric {
	@Autowired
	private User_repository userRepo;
	@Autowired
	private TournamentRepo tourRepo;
	@Autowired
	private TeamRepo tmrepo;
	
public void addUser(UserDetails e) {
	userRepo.save(e);
}
public void addTournament(Tournaments t) {
	tourRepo.save(t);
}
public List<UserDetails> getAllUsers(){
	return userRepo.findAll();
	}
public UserDetails findUserByEmail(String user_email) {
	// TODO Auto-generated method stub
	return userRepo.findByUserEmail(user_email);
}
public String  Getusertype(String user_email) {
	return userRepo.Getusertype(user_email);
}
public String Getuserpassword(String  user_email ) {
	return userRepo.Getuserpassword(user_email);
}
public void addTeams(Teams team) {
	tmrepo.save(team);
}

public Long getwalletBalance (String email) {
	return userRepo.getwalletBalance(email);
}
@Transactional
public void updateWallet(String email,Long id) {
	userRepo.updateWallet(email, id);
}

@Transactional
public void deleteUser(String email) {
	// TODO Auto-generated method stub
	userRepo.deleteUser(email);
	
}


  @Transactional 
  public void updateName(String email,String name) { // TODO
userRepo.updateName(email,name);
  
  }
  
  @Transactional 
  public void updatePassword(String email, String password) { //
  userRepo.updatePassword(email,password); }
public Long getWinningprize(String email) {
	// TODO Auto-generated method stub
	return userRepo.getWinningprize(email);
}

@Transactional
public void updateWinningprize(String email, Long winning) {
	// TODO Auto-generated method stub
	userRepo.updateWinningprize(email,winning);
}
public List<UserDetails> orderByWin() {
	// TODO Auto-generated method stub
	return userRepo.orderBywin();
}
 
}
