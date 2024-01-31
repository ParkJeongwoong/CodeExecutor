package com.boilerplate.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Rock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String color;

	@Column(nullable = false)
	private RockShape shape;

	@Column(nullable = false)
	private int size;

	@Column(nullable = false)
	private double weight;

	public Rock(String color, RockShape shape, int size, double weight) {
		this.color = color;
		this.shape = shape;
		this.size = size;
		this.weight = weight;
	}

}