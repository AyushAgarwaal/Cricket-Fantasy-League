package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="teams")
public class Teams {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Long id;

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

@Column(name="name")
private String name;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "match_id",referencedColumnName = "id")
private Matches match;



public Matches getMatchRef() {
	return match;
}

public void setMatchRef(Matches match) {
	this.match = match;
} 



}