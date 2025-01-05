package com.poc.core.domain.dto;

import com.poc.core.domain.valueobject.Plate;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MakeCheckoutDTO {

	private Plate plate;

	private LocalDateTime checkoutDate;

}
