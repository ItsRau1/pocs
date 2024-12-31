package com.poc.core.domain.repository;

import com.poc.core.domain.entity.CheckIn;

import java.util.Optional;

public interface CheckRepository {

	CheckIn save(CheckIn checkIn);

	CheckIn update(CheckIn checkIn);

	Optional<CheckIn> findById(Long id);

}
