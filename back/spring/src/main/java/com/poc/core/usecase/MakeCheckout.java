package com.poc.core.usecase;

import com.poc.core.domain.dto.MakeCheckoutDTO;
import com.poc.core.domain.entity.Check;
import com.poc.core.domain.repository.CheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MakeCheckout {

	private final CheckRepository checkRepository;

	public Check execute(MakeCheckoutDTO dto) {
		Check check = checkRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Check not found"));
		check.checkOut();
		return checkRepository.update(check);
	}

}
