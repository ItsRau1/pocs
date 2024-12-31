package com.poc.core.domain.exception;

import java.sql.SQLException;

public class ConnectionException {

	public ConnectionException(String message) {
		System.out.printf("Error in Connection: %s", message);
		throw new RuntimeException(message);
	}

}
