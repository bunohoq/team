package com.test.team.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblTeam")
public class Team {
	
	@Id
	@SequenceGenerator(name = "seqTeamGen", allocationSize = 1, sequenceName = "seqTeam")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTeamGen")
	private Long seq;
	
	private String name;
	private String description;
	
}
