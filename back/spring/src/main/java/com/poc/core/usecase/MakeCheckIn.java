package com.poc.core.usecase;

import com.poc.core.domain.dto.MakeCheckInDTO;
import com.poc.core.domain.entity.CheckIn;
import com.poc.core.domain.repository.CheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MakeCheckIn {

	private final CheckRepository checkRepository;

	public CheckIn execute(MakeCheckInDTO dto) {
		CheckIn checkIn = CheckIn.builder()
			.plate(dto.getPlate())
			.location(dto.getLocation())
			.checkInDate(dto.getCheckInDate())
			.build();
		checkIn.register();
		return checkRepository.save(checkIn);
	}

}
