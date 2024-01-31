package com.boilerplate.springboot.application.rock.repository;

import com.boilerplate.springboot.domain.Rock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RockRepository extends JpaRepository<Rock, Long> {

}
