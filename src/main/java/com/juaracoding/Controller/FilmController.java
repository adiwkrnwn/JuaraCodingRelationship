package com.juaracoding.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.Repository.FilmRepository;
import com.juaracoding.model.CustomerScreeningFilmCategory;

@RestController
@RequestMapping("/film")
public class FilmController {
	
	@Autowired
	FilmRepository filmRepo;
	
	@GetMapping("category/")
	private List<CustomerScreeningFilmCategory> getCategoryFilm() {
		return filmRepo.getDataCategoryFilm();
	}

}
