package com.example.demo.entity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="tournaments_details")
public class Tournaments {
	@Override
	public String toString() {
		return "Tournaments [tour_id=" + tour_id + ", name=" + name + ", year=" + year + ", venue=" + venue
				+ ", total_teams=" + total_teams + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Long getTotal_teams() {
		return total_teams;
	}
	public void setTotal_teams(Long total_teams) {
		this.total_teams = total_teams;
	}
	@Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tour_id")
	private Long tour_id;
	
	public Long getTour_id() {
		return tour_id;
	}
	public void setTour_id(Long tour_id) {
		this.tour_id = tour_id;
	}
	@Column(name="tour_name")
	private String name;
	
	
	@Column(name="tour_year")
	private String year;
	@Column(name="tour_venue")
	private String venue;
	@Column(name="total_teams")
	private Long total_teams;
}
