package com.juaracoding.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.Repository.BookingRepository;
import com.juaracoding.model.BookingModel;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingRepository bookingRepo;
	
	@GetMapping("/")
	private List<BookingModel> getAll() {
		return bookingRepo.findAll();
	}
	
	@PostMapping("/")
	private String insertBooking(@RequestBody BookingModel booking) {
		bookingRepo.save(booking);
		return "berhasil";
	}
	
	@GetMapping("/namadepan/{firstname}")
	private List<BookingModel> getBookingByFirstName(
			@PathVariable("firstname") String name) {
		return bookingRepo.findByCustomerId_firstName(name);
	}
	
	@GetMapping("/namabelakang/{lastname}")
	private List<BookingModel> getBookingBylastName(
			@PathVariable("lastname") String name) {
		return bookingRepo.findByCustomerId_lastName(name);
	}
	
	@GetMapping("/maxseat/{maxseat}")
	private List<BookingModel> getBookingMaxOfSeat(
			@PathVariable("maxseat") int name) {
		return bookingRepo.findBySeatIdRoomIdMaxOfSeat(name);
	}
	
	@GetMapping("/category/{category}")
	private List<BookingModel> getBookingCategory(
			@PathVariable("category") String name) {
		return bookingRepo.findByScreeningIdFilmIdCategory(name);
	}

}
