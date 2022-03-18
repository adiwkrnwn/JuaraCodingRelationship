package com.juaracoding.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.Repository.SeatRepository;
import com.juaracoding.model.SeatModel;

@RestController
@RequestMapping("/seat")
public class SeatController {
	
	@Autowired
	SeatRepository seatRepo;
	
	@PostMapping("/")
	private String insertSeat (@RequestBody SeatModel seat) {
		seatRepo.save(seat);
		return "berhasil ditambahkan";
	}

}
