package com.poc.core.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CheckIn {

	private String id;

	private String plate;

	private LocalDateTime checkInDate;

	private String location;

	public void register() {
		this.id = UUID.randomUUID().toString();
	}

}
