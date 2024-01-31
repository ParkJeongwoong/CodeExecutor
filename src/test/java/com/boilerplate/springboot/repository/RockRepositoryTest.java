package com.boilerplate.springboot.repository;

import com.boilerplate.springboot.application.rock.repository.RockRepository;
import com.boilerplate.springboot.domain.Rock;
import com.boilerplate.springboot.domain.RockShape;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RockRepositoryTest {

	@Autowired
	RockRepository rockRepository;

	@BeforeEach
	public void setUp() {
		Rock rock = new Rock("Green", RockShape.ROUND, 5, 7.2);
		rockRepository.save(rock);
	}

	@AfterEach
	public void cleanUp() {
		rockRepository.deleteAll();
	}

	@Test
	public void save_test() {
		// given
		Rock rock = new Rock("Green", RockShape.ROUND, 5, 7.2);

		// when
		Rock savedRock = rockRepository.save(rock);

		// then
		assertThat(savedRock.getId()).isNotNull();
		assertThat(savedRock.getColor()).isEqualTo(rock.getColor());
		assertThat(savedRock.getShape()).isEqualTo(rock.getShape());
		assertThat(savedRock.getSize()).isEqualTo(rock.getSize());
		assertThat(savedRock.getWeight()).isEqualTo(rock.getWeight());
	}

	@Test
	@DisplayName("Rock 조회 테스트")
	public void findById_test() {
		// given
		long id = 1L;

		// when
		Optional<Rock> findRock = rockRepository.findById(id);

		// then
		assertThat(findRock).isPresent();
		assertThat(findRock.get().getColor()).isEqualTo("Green");
		assertThat(findRock.get().getShape()).isEqualTo(RockShape.ROUND);
		assertThat(findRock.get().getSize()).isEqualTo(5);
		assertThat(findRock.get().getWeight()).isEqualTo(7.2);
	}

}
