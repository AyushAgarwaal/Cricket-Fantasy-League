package com.example.demo.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leaderboard")
public class Leaderboard {

 @Id
	 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
     
	 @Column(name = "id")
	private Long id;
	@Column(name="tournament")
	private String tournament;
	@Column(name="matchname")
	private String matchname;
	@Column(name="team")
	private String team;
	public String getTournament() {
		return tournament;
	}
	public void setTournament(String tournament) {
		this.tournament = tournament;
	}
	public String getMatchname() {
		return matchname;
	}
	public void setMatchname(String matchname) {
		this.matchname = matchname;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
}
