package com.example.demo.reservationTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

@SpringBootTest
public class ReservationRepositoryTest {
	
	@Autowired
	ReservationRepository repository;
	
	@Test
	void 예약정보_등록() {

		Reservation reservation = Reservation.builder()
											 .checkInDate(LocalDate.of(2024,9,10))
											 .guestName("도우너")
											 .guestPhone(null)
											 .roomNo(201)
											 .build();
		
		repository.save(reservation);
	}
	
	
	@Test
	void 예약정보_조회() {
		List<Reservation> list = repository.findAll();
		for(Reservation reservation : list) {
			System.out.println(reservation);
		}
	}
	
	
	@Test
	void 게시물단건조회() {
		Optional<Reservation> result = repository.findById(1);
		if(result.isPresent()) {
			Reservation reservation = result.get();
			System.out.println(reservation);
		}
	}
	

	@Test
	void 예약정보_수정() {
		Optional<Reservation> result = repository.findById(3);
		Reservation reservation = result.get();
		reservation.setGuestName("도우너");
		repository.save(reservation);
	}
	
	
	@Test
	void 예약정보_삭제() {
		repository.deleteById(3);
	}

}
















