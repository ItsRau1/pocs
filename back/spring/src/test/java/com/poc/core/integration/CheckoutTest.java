package com.poc.core.integration;

import com.poc.core.domain.dto.MakeCheckInDTO;
import com.poc.core.domain.entity.Check;
import com.poc.core.usecase.MakeCheckIn;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
@RequiredArgsConstructor
public class CheckoutTest {

	@Autowired
	MakeCheckIn makeCheckIn;

	// @Autowired
	// MakeCheckOut makeCheckOut;

	@Test
	void deveSerPossivelRealizarCheckout() {
		MakeCheckInDTO makeCheckInDTO = MakeCheckInDTO.builder()
			.location("shopping")
			.checkInDate(LocalDateTime.now())
			.plate(UUID.randomUUID().toString().substring(0, 9))
			.build();
		Check checkin = makeCheckIn.execute(makeCheckInDTO);
		Assertions.assertNotNull(checkin);
		Assertions.assertEquals(makeCheckInDTO.getPlate(), checkin.getPlate());
		Assertions.assertEquals(makeCheckInDTO.getCheckInDate(), checkin.getCheckInDate());
		// MakeCheckOutDTO makeCheckOutDTO = MakeCheckoutDTO.builder()
		// .plate(checkin.getPlate())
		// .checkoutDate(LocalDateTime.now().plusHours(3))
		// .build();
		// CheckoOut checkOut = makeCheckOut.execute(makeCheckOutDTO);
		// Assertions.assertNotNull(checkOut);
		// Assertions.assertEquals(makeCheckOutDTO.getPlate(), checkOut.getPlate());
		// Assertions.assertEquals(makeCheckOutDTO.getCheckOutDate(),
		// checkOut.getCheckOutDate());
	}

}
