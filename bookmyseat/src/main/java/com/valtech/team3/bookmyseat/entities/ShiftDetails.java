package com.valtech.team3.bookmyseat.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
public class ShiftDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 20)
	private String shiftName;
	@Column(nullable = false, columnDefinition = "TIME")
	private LocalTime startTime;
	@Column(nullable = false, columnDefinition = "TIME")
	private LocalTime endTime;
	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime createdDate;
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime modifiedDate;

	public ShiftDetails(int id, String shiftName, LocalTime startTime, LocalTime endTime, LocalDateTime createdDate) {
		this.id = id;
		this.shiftName = shiftName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdDate = createdDate;
	}

}
