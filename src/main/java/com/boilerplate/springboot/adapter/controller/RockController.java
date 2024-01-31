package com.boilerplate.springboot.adapter.controller;

import com.boilerplate.springboot.application.rock.dto.RockRequestDto;
import com.boilerplate.springboot.application.rock.dto.RockResponseDto;
import com.boilerplate.springboot.application.rock.service.RockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Rock API", description = "CRUD 참고용 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/rock")
public class RockController {

	private final RockService rockService;

	@Operation(summary = "Rock 생성", description = "Rock 데이터를 생성하는 API")
	@PostMapping("/")
	public ResponseEntity<RockResponseDto> save(@RequestBody RockRequestDto requestDto) {
		return ResponseEntity.ok(rockService.save(requestDto));
	}

	@Operation(summary = "Rock 조회", description = "Rock 데이터를 조회하는 API")
	@GetMapping("/{id}")
	public ResponseEntity<RockResponseDto> findById(@PathVariable long id) {
		return ResponseEntity.ok(rockService.findById(id));
	}

}
