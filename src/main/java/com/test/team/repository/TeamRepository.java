package com.test.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.team.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

}
