package com.poc.core.usecase;

import com.poc.core.domain.dto.MakeCheckInDTO;
import com.poc.core.domain.entity.Check;
import com.poc.core.domain.repository.CheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MakeCheckIn {

	private final CheckRepository checkRepository;

	public Check execute(MakeCheckInDTO dto) {
		Check check = Check.builder()
			.plate(dto.getPlate())
			.location(dto.getLocation())
			.checkInDate(dto.getCheckInDate())
			.build();
		check.register();
		return checkRepository.save(check);
	}

}
