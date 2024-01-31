package com.boilerplate.springboot.service;

import com.boilerplate.springboot.application.rock.dto.RockRequestDto;
import com.boilerplate.springboot.application.rock.dto.RockResponseDto;
import com.boilerplate.springboot.application.rock.repository.RockRepository;
import com.boilerplate.springboot.application.rock.service.RockService;
import com.boilerplate.springboot.domain.Rock;
import com.boilerplate.springboot.domain.RockShape;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
public class RockServiceTest {

	@Mock
	RockRepository rockRepository;

	@InjectMocks
	RockService rockService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this); // @Mock으로 설정한 객체를 초기화
	}

	@Test
	@DisplayName("Rock 저장 테스트")
	public void save_test() {
		// given
		RockRequestDto inputRock = new RockRequestDto("Green", "round", 5, 7.2);
		Rock expectedRock = new Rock("Green", RockShape.ROUND, 5, 7.2);
		when(rockRepository.save(any(Rock.class))).thenReturn(expectedRock);

		// when
		RockResponseDto actualRock = rockService.save(inputRock);

		// then
		log.info("findRock color = " + actualRock.getColor());
		log.info("findRock shape = " + actualRock.getShape());
		log.info("findRock size = " + actualRock.getSize());
		log.info("findRock weight = " + actualRock.getWeight());
		assertThat(actualRock.getColor()).isEqualTo(expectedRock.getColor());
		assertThat(actualRock.getShape()).isEqualTo(expectedRock.getShape().toString());
		assertThat(actualRock.getSize()).isEqualTo(expectedRock.getSize());
		assertThat(actualRock.getWeight()).isEqualTo(expectedRock.getWeight());
	}

	// findById를 save와 같이 테스트하면, save가 먼저 실행되어야 하기 때문에 테스트가 실패할 수 있다.
	// 따라서 Mockito를 사용하여 findById를 별도로 테스트한다.
	@Test
	@DisplayName("Rock 조회 테스트")
	public void findById_test() {
		// given
		Rock expectedRock = new Rock("Green", RockShape.ROUND, 5, 7.2);
		expectedRock.setId(1L);
		when(rockRepository.findById(anyLong())).thenReturn(java.util.Optional.of(expectedRock));

		// when
		Rock a = rockRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당하는 바위가 없습니다. id=" + 1L));
		log.info("a color = " + a.getColor());
		RockResponseDto findRock = rockService.findById(expectedRock.getId());

		// then
		log.info("findRock color = " + findRock.getColor());
		log.info("findRock shape = " + findRock.getShape());
		log.info("findRock size = " + findRock.getSize());
		log.info("findRock weight = " + findRock.getWeight());
		assertThat(findRock.getColor()).isEqualTo(expectedRock.getColor());
		assertThat(findRock.getShape()).isEqualTo(expectedRock.getShape().toString());
		assertThat(findRock.getSize()).isEqualTo(expectedRock.getSize());
		assertThat(findRock.getWeight()).isEqualTo(expectedRock.getWeight());
	}

}
