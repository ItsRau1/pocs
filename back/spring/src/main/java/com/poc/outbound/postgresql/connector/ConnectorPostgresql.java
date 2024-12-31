package com.poc.outbound.postgresql.connector;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

	public void startConnection() {
		try {
			connection = DriverManager.getConnection(URL, getProperties());
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public Statement getStatement() {
		try {
			return connection.createStatement();
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void executeUpdate(String sql) {
		try {
			this.startConnection();
			this.getStatement().executeUpdate(sql);
			this.endConnection();
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
		return props;
	}

}
