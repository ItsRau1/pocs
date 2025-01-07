package com.poc.outbound.postgresql.repository;

import com.poc.core.domain.entity.Check;
import com.poc.core.domain.repository.CheckRepository;
import com.poc.core.domain.valueobject.Plate;
import com.poc.outbound.postgresql.connector.ConnectorPostgresql;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
		postgresqlUtils.executeUpdate(sql);
		return check;
	}

	@Override
	public Check update(Check check) {
		String sql = String.format(
				"UPDATE check_in " + "SET " + "cost = %s, " + "check_out_date = %s," + "WHERE id = %s", check.getCost(),
				check.getCheckoutDate(), check.getId());
		postgresqlUtils.executeUpdate(sql);
		return check;
	}

	@Override
	public Optional<Check> findById(String id) {
		String sql = String.format("SELECT * FROM check_in WHERE id = '%s'", id);
		ResultSet resultSet = postgresqlUtils.executeQuery(sql);
		return Optional.ofNullable(mapToCheck(resultSet));
	}

	private Check mapToCheck(ResultSet resultSet) {
		try {
			Check check = null;
			while (resultSet.next()) {
				check = Check.builder()
					.id(resultSet.getString("id"))
					.checkInDate(mapStringToLocalDateTime(resultSet.getString("check_in_date")))
					.checkoutDate(mapStringToLocalDateTime(resultSet.getString("check_out_date")))
					.location(resultSet.getString("location"))
					.plate(resultSet.getString("plate"))
					.build();
			}
			return check;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private LocalDateTime mapStringToLocalDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return LocalDateTime.parse(date, formatter);
	}

}
