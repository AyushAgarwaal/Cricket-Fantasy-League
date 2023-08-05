package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.DynamicEntity;
import com.example.demo.entity.Matches;

public interface MatchRepo extends JpaRepository<Matches, Long>{

	
	/*
	 * @Query(
	 * value="select m.name from matches m JOIN tournaments_details td  ON m.tour_id=td.tour_id where m.tour_id=:TourId"
	 * ,nativeQuery = true) List<String> findTourById(Long TourId);
	 */

	 
	 @Query(value = "     select distinct m.name, m.id \n" +
		        "from matches m JOIN tournaments_details td  ON m.tour_id=td.tour_id where m.tour_id=:TourId" ,nativeQuery = true)
		List<DynamicEntity> findTourById(Long TourId);
	 
	 
	@Query(value="select name from matches where name=:name",nativeQuery = true) String findEnteredMatch(	String name);


	@Query(value="select name from matches where tour_id=:tourid",nativeQuery = true)  List<String> findTourname(@Param("tourid") Long tourid);


	@Query(value="SELECT tour_id FROM Matches  WHERE id = :matchid",nativeQuery = true) Long findtour(@Param("matchid") Long matchid);


	@Query(value="select name from Matches where id=:matchid")String findMatchname(@Param("matchid") Long matchid);


	 
}
