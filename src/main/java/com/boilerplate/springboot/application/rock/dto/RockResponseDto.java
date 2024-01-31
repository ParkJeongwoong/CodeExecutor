package com.boilerplate.springboot.application.rock.dto;

import com.boilerplate.springboot.domain.Rock;
import lombok.Getter;

@Getter
public class RockResponseDto {

	private final long id;
	private final String color;
	private final String shape;
	private final int size;
	private final double weight;

	public RockResponseDto(Rock rock) {
		this.id = rock.getId();
		this.color = rock.getColor();
		this.shape = rock.getShape().toString();
		this.size = rock.getSize();
		this.weight = rock.getWeight();
	}

}
