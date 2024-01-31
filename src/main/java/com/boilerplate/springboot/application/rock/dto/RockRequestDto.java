package com.boilerplate.springboot.application.rock.dto;

import com.boilerplate.springboot.domain.Rock;
import com.boilerplate.springboot.domain.RockShape;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RockRequestDto {

	private String color;
	private String shape;
	private int size;
	private double weight;

	public RockRequestDto(String color, String shape, int size, double weight) {
		this.color = color;
		this.shape = shape;
		this.size = size;
		this.weight = weight;
	}

	public Rock toEntity() {
		RockShape shape = RockShape.valueOf(this.shape.toUpperCase());
		return new Rock(this.color, shape, this.size, this.weight);
	}

}
