package com.poc.core.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MakeCheckInDTO {

	private String plate;

	private LocalDateTime checkInDate;

	private String location;

}
