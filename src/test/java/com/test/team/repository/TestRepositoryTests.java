package com.test.team.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRepositoryTests {

	@Autowired
	private TestRepository repo;
	
	@DisplayName("숫자 테스트")
	@Test
	void testNum() {
		assertEquals(100, repo.num());
	}
	
	

}
