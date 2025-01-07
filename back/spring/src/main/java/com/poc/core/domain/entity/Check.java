package com.poc.core.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Check {

	private String id;

	private String plate;

	private String location;

	private BigDecimal cost;

	private LocalDateTime checkInDate;

	private LocalDateTime checkoutDate;

	public void register() {
		this.id = UUID.randomUUID().toString();
	}

	public void checkOut() {
		this.checkoutDate = LocalDateTime.now();
		// TODO: calculate cost
	}

}
