package com.juaracoding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="film")
public class FilmModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long filmId;
	private String filmName;
	private String category;
	private String subTilte;

}
