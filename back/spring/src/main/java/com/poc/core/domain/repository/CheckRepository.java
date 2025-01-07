package com.poc.core.domain.repository;

import com.poc.core.domain.entity.Check;
import com.poc.core.domain.valueobject.Plate;

import java.util.Optional;

public interface CheckRepository {

	Check save(Check check);

	Check update(Check check);

	Optional<Check> findById(String id);

}
