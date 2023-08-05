package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Repository;
//
import com.example.demo.entity.UserDetails;

import jakarta.transaction.Transactional;

@Repository
public interface User_repository extends JpaRepository<UserDetails, Long> {

	@Query(value = "select * from user_details where user_email=:user_email", nativeQuery = true)
	UserDetails findByUserEmail(String user_email);

	@Query(value = "select user_type from user_details where user_email=:user_email", nativeQuery = true)
	String Getusertype(String user_email);

	@Query(value = "select user_password from user_details where user_email=:user_email", nativeQuery = true)
	String Getuserpassword(String user_email);

	@Query(value = "select walletbalance from user_details where user_email=:email", nativeQuery = true)
	Long getwalletBalance(String email);

	/*
	 * @Modifying
	 * 
	 * @Query(value =
	 * "UPDATE user_details SET walletbalance = ?2 WHERE user_email = ?1"
	 * ,nativeQuery = true) void updateWallet(String email,Long wallet);
	 */


@Modifying

@Query(value="UPDATE UserDetails SET wallet = :id WHERE userEmail = :email ") 
public void updateWallet(@Param("email") String email,@Param("id") Long id);


@Modifying
@Query(value="delete from UserDetails where userEmail=:email")
void deleteUser(String email);

@Modifying
@Query(value="UPDATE UserDetails SET userName = :name WHERE userEmail = :email ")
void updateName(@Param("email") String email,@Param("name") String name);


@Modifying
@Query(value="UPDATE UserDetails SET password = :password WHERE userEmail = :email ")
void updatePassword(@Param("email")String email,@Param("password")  String password);

@Query(value="select winningPrize from UserDetails where userEmail=:email")Long getWinningprize(String email);

@Modifying
@Query(value="UPDATE UserDetails SET winningPrize = :winning WHERE userEmail = :email ")
void updateWinningprize(String email, Long winning);

@Query(value="SELECT * FROM user_details ORDER BY winning_prize DESC",nativeQuery = true)
List<UserDetails> orderBywin();


}

//	Optional<User_Registered> findByUser_email(String user_email);
