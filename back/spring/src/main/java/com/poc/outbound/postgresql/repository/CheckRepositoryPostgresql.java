package com.poc.outbound.postgresql.repository;

import com.poc.core.domain.entity.Check;
import com.poc.core.domain.repository.CheckRepository;
import com.poc.core.domain.valueobject.Plate;
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
	public Check save(Check check) {
		String sql = String.format(
				"INSERT INTO check_in (id, plate, location, check_in_date) VALUES ('%s', '%s', '%s', '%s')",
				check.getId(), check.getPlate(), check.getLocation(), check.getCheckInDate());
		System.out.println(sql);
		postgresqlUtils.executeUpdate(sql);
		return check;
	}

	@Override
	public Check update(Check check) {
		return null;
	}

	@Override
	public Optional<Check> findByPlate(Plate plate) {
		return Optional.empty();
	}

}
