package com.juaracoding.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="screening")
public class ScreeningModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long screeningId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "filmId", referencedColumnName = "filmId")
	private FilmModel filmId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "roomId", referencedColumnName = "roomId")
	private RoomModel roomId;
	private String date;

}
