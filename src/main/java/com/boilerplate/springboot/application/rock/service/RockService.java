package com.boilerplate.springboot.application.rock.service;

import com.boilerplate.springboot.application.rock.dto.RockRequestDto;
import com.boilerplate.springboot.application.rock.dto.RockResponseDto;
import com.boilerplate.springboot.application.rock.repository.RockRepository;
import org.springframework.stereotype.Service;

@Service
public class RockService {

	private RockRepository rockRepository;

	public RockService(RockRepository rockRepository) {
		this.rockRepository = rockRepository;
	}

	public RockResponseDto save(RockRequestDto requestDto) {
		return new RockResponseDto(rockRepository.save(requestDto.toEntity()));
	}

	public RockResponseDto findById(long id) {
		return new RockResponseDto(rockRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 바위가 없습니다. id=" + id)));
	}

}
