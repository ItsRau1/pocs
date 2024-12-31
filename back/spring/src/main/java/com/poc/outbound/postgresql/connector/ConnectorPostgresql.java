package com.poc.outbound.postgresql.connector;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
@RequiredArgsConstructor
public class ConnectorPostgresql {

	@Value("${postgresql.url}")
	private String URL;

	@Value("${postgresql.username}")
	private String USER;

	@Value("${postgresql.password}")
	private String PASSWORD;

	private Connection connection;

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(URL, getProperties());
			return connection;
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void endConnection() {
		try {
			connection.close();
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private Properties getProperties() {
		Properties props = new Properties();
		props.setProperty("user", USER);
		props.setProperty("password", PASSWORD);
		props.setProperty("ssl", "true");
		return props;
	}

}
