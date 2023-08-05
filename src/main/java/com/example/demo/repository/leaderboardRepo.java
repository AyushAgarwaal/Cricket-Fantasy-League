package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Leaderboard;

@Repository
public interface leaderboardRepo extends JpaRepository<Leaderboard, Long>{

}
