package com.juaracoding.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.Repository.ScreeningRepository;
import com.juaracoding.model.ScreeningCustomeFilm;
import com.juaracoding.model.ScreeningModel;

@RestController
@RequestMapping("/screening")
public class ScreeningController {
	
	@Autowired
	ScreeningRepository screeningRepo;
	
	@PostMapping("/")
	private String insertScreening(@RequestBody ScreeningModel screening) {
		screeningRepo.save(screening);
		return "berhasil";
	}
	
	@GetMapping("/{date}")
	private List<ScreeningModel> getAllByScreeningDate (@PathVariable("date") String date) {
		return screeningRepo.findByDate(date);
	}
	
	@GetMapping("filmid/")
	private List<ScreeningCustomeFilm> getScreeningFilm() {
		return screeningRepo.getScreeningFilmId();
	}
	

}
