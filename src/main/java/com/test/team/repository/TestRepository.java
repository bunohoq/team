package com.test.team.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
	
	public Integer num() {
		
		//올바른 결과: 100
		return 200;
	}

}
