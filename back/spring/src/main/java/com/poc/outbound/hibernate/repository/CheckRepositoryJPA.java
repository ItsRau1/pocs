package com.poc.outbound.hibernate.repository;

import com.poc.core.domain.entity.Check;
import com.poc.core.domain.repository.CheckRepository;
import com.poc.outbound.hibernate.table.CheckTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CheckRepositoryJPA implements CheckRepository extends JpaRepository<CheckTable, String> {

	@Override
	public Check save(Check check) {
		return null;
	}

	@Override
	public Check update(Check check) {
		return null;
	}

	@Override
	public Optional<Check> findById(Long id) {
		return Optional.empty();
	}

}
