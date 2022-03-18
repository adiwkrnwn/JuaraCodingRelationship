package com.juaracoding.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.juaracoding.model.CustomerScreeningFilmCategory;
import com.juaracoding.model.FilmModel;

public interface FilmRepository extends JpaRepository<FilmModel, Long> {
	
	@Query(value = "SELECT `category`, `film_name` FROM `film`", nativeQuery = true)
	List<CustomerScreeningFilmCategory> getDataCategoryFilm();

}
