package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DynamicEntity;
import com.example.demo.entity.Teams;

@Repository
public interface TeamRepo extends JpaRepository<Teams, Long>{

	@Query(value= "     select distinct t.name, t.id \n" +
	        "from teams t JOIN matches m  ON t.match_id=m.id where t.match_id=:id",nativeQuery = true)List<DynamicEntity> findTeamById(Long id);

	@Query(value="select t.name from Teams t JOIN t.match m JOIN m.tour tr WHERE m.id=:id AND tr.tour_id=:tourid")  List<String> findteamname(@Param("id") Long id,@Param("tourid") Long tourid);

	@Query(value="SELECT match_id FROM Teams  WHERE id = :teamid",nativeQuery = true)  Long findmatch(@Param("teamid")Long teamid);

	@Query(value="select id from Teams where match_id=:match AND id<>:team",nativeQuery = true) Long findlose(Long match, Long team);

	@Query(value="select name from Teams where id=:teamid")
	String findteam(@Param("teamid") Long teamid);


	
	/* @Modifying
	  @Query(value="UPDATE user_details SET walletbalance = :id WHERE user_email = :email ")
	  void updateWallet(@Param("email") String email,@Param("id") Long id);
}*/
}