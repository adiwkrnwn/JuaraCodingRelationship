package com.juaracoding.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.Repository.RoomRepository;
import com.juaracoding.model.RoomModel;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	RoomRepository roomRepo;
	
	@PostMapping("/")
	private String insertRoom(@RequestBody RoomModel room) {
		roomRepo.save(room);
		return "berhasil";
	}

}
