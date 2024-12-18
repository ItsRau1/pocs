package com.poc.core.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Check {

	private String id;

	private String plate;

	private LocalDateTime checkInDate;

	private String location;

}
