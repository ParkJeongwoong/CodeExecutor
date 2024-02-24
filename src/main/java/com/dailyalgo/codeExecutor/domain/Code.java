package com.dailyalgo.codeExecutor.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Code {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private final String code;
	@Column(nullable = false)
	private final String language;

	public Code(String code, String language) {
		this.code = code;
		this.language = language;
	}

}
