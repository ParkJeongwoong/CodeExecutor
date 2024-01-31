package com.boilerplate.springboot.domain;

public enum RockShape {

	ROUND("round"),
	SQUARE("square"),
	TRIANGLE("triangle"),
	HEART("heart"),
	STAR("star"),
	OTHER("other");

	private final String shape;

	RockShape(String shape) {
		this.shape = shape;
	}

}