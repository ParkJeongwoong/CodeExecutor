package com.dailyalgo.codeExecutor.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Problem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private final String title;
	@Column(nullable = false)
	private final String description;

	@OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
	private final List<Case> caseList = new ArrayList<>();

	public Problem(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Problem(String title, String description, List<Case> caseList) {
		this.title = title;
		this.description = description;
		this.caseList.addAll(caseList);
	}

	public void addCase(Case c) {
		this.caseList.add(c);
	}

	public void removeCase(Case c) {
		this.caseList.remove(c);
	}

}
