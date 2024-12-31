package com.poc.outbound.postgresql.repository;

import com.poc.core.domain.entity.Check;
import com.poc.core.domain.repository.CheckRepository;
import com.poc.outbound.postgresql.connector.ConnectorPostgresql;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class CheckRepositoryPostgresql implements CheckRepository {

	private ConnectorPostgresql connector;

	// TODO: Create anotation to start connection and endConnection when start and end the method
	@Override
	public Check save(Check check) {
		connector.getConnection();
		connector.endConnection();
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
