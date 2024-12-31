package com.poc.outbound.postgresql.repository;

import com.poc.core.domain.entity.CheckIn;
import com.poc.core.domain.repository.CheckRepository;
import com.poc.outbound.postgresql.connector.ConnectorPostgresql;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class CheckRepositoryPostgresql implements CheckRepository {

	private final ConnectorPostgresql postgresqlUtils;

	// TODO: Create anotation to start connection and endConnection when start and end the
	// method
	@Override
	public CheckIn save(CheckIn checkIn) {
		String sql = String.format(
				"INSERT INTO check_in (id, plate, location, check_in_date) VALUES ('%s', '%s', '%s', '%s')",
				checkIn.getId(), checkIn.getPlate(), checkIn.getLocation(), checkIn.getCheckInDate());
		System.out.println(sql);
		postgresqlUtils.executeUpdate(sql);
		return checkIn;
	}

	@Override
	public CheckIn update(CheckIn checkIn) {
		return null;
	}

	@Override
	public Optional<CheckIn> findById(Long id) {
		return Optional.empty();
	}

}
