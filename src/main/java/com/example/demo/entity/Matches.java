package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="matches")
public class Matches {
	public Matches(Long id, String name, String venue, Tournaments tour) {
		super();
		this.id = id;
		this.name = name;
		this.venue = venue;
		this.tour = tour;
	}
	
	public Matches() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name; 
	
	@Column(name="venue")
	private String venue;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id",referencedColumnName = "tour_id")
	private Tournaments tour; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tournaments getTour() {
		return tour;
	}

	public void setTour(Tournaments tour) {
		this.tour = tour;
	}
	
	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		return "Matches [id=" + id + ", name=" + name + ", venue=" + venue + ", tour=" + tour + "]";
	}

	
}
