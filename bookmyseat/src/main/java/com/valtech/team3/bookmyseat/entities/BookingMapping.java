package com.valtech.team3.bookmyseat.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BookingMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(targetEntity = Booking.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "bookingId", referencedColumnName = "id", nullable = false)
	private Booking booking;
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate bookedDate;
	@Column(nullable = false, columnDefinition = "BIT DEFAULT false")
	private boolean attendance;

	public BookingMapping(int id, Booking booking, LocalDate bookedDate, boolean attendance) {
		this.id = id;
		this.booking = booking;
		this.bookedDate = bookedDate;
		this.attendance = attendance;
	}

}
