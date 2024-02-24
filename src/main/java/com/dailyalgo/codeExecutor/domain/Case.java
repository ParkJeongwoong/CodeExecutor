package com.dailyalgo.codeExecutor.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Case {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private final Problem problem;

	@Column(nullable = false)
	private final int type; // 1: sample, 2: test

	@Column(nullable = false)
	private final String input;

	@Column(nullable = false)
	private final String output;

	public Case(Problem problem, int type, String input, String output) {
		this.problem = problem;
		this.type = type;
		this.input = input;
		this.output = output;
	}

}
