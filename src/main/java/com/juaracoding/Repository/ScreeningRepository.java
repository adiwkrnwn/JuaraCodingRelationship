package com.juaracoding.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.juaracoding.model.ScreeningCustomeFilm;
import com.juaracoding.model.ScreeningModel;

public interface ScreeningRepository extends JpaRepository<ScreeningModel, Long> {

	List<ScreeningModel> findByDate(String date);
	
	@Query(value = "SELECT `film_id` FROM `screening`", nativeQuery = true)
	List<ScreeningCustomeFilm> getScreeningFilmId();

}
