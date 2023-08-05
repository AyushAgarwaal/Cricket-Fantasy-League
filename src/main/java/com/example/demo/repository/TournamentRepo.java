package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tournaments;
@Repository
public interface TournamentRepo extends JpaRepository<Tournaments , Long> {

	@Query(value="select tour_name from tournaments_details where tour_id=:tourid",nativeQuery = true)
	String findtour(Long tourid);
 
}
