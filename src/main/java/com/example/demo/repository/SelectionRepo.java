
  package com.example.demo.repository;
  
  import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import
  org.springframework.stereotype.Repository;

import com.example.demo.entity.Selection;
  
  @Repository public interface SelectionRepo extends
  JpaRepository<Selection, Long>{

	@Query(value="select team from user_selection where useremail=:email",nativeQuery = true)List<Long> findTeamByIdEmail(String email);

	@Modifying
	@Query(value="update Selection set status=:statusnew where team=:team") void updateStatus( @Param("team")Long team,@Param("statusnew")String statusnew);

	@Query(value="select id from user_selection where useremail=:email and team=:teamid",nativeQuery = true)
	Long findId(@Param("email")String email,@Param("teamid")Long teamid);

	
	@Query(value="select status from user_selection where id=:id ",nativeQuery = true)
	String findStatus(@Param("id") Long id);
	@Query(value="select useremail from Selection where team=:team")
	List<String> findemail(Long team);


	

		
		
		
		
		
		 
		 
	
		  
  }
 