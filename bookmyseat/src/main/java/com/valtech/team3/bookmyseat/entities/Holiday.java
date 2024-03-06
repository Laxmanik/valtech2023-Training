package com.valtech.team3.bookmyseat.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 30)
	private String holidayName;
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate holidayDate;

	public Holiday(int id, String holidayName, LocalDate holidayDate) {
		this.id = id;
		this.holidayName = holidayName;
		this.holidayDate = holidayDate;
	}

}