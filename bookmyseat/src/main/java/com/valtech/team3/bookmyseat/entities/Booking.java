package com.valtech.team3.bookmyseat.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BookingRange bookingRange;
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate startDate;
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate endDate;
	@Column(nullable = false, columnDefinition = "BIT DEFAULT false")
	private boolean lunch;
	@Column(nullable = false, columnDefinition = "BIT DEFAULT false")
	private boolean beverage;
	@Column(nullable = false, columnDefinition = "BIT DEFAULT false")
	private boolean parking;
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;
	@Column(nullable = false, columnDefinition = "BIT DEFAULT false")
	private boolean addtionalDesktop;
	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime createdDate;
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime modifiedDate;
	@ManyToOne(targetEntity = User.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
	private User user;
	@ManyToOne(targetEntity = ShiftDetails.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "shiftId", referencedColumnName = "id", nullable = false)
	private ShiftDetails shiftDetails;
	@ManyToOne(targetEntity = Seat.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "seatId", referencedColumnName = "id", nullable = false)
	private Seat seat;

	public Booking(
	      int id, BookingRange bookingRange, LocalDate startDate, LocalDate endDate, boolean lunch, boolean beverage, boolean parking, VehicleType vehicleType, boolean addtionalDesktop,
	      LocalDateTime createdDate, User user, ShiftDetails shiftDetails, Seat seat
	) {
		this.id = id;
		this.bookingRange = bookingRange;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lunch = lunch;
		this.beverage = beverage;
		this.parking = parking;
		this.vehicleType = vehicleType;
		this.addtionalDesktop = addtionalDesktop;
		this.createdDate = createdDate;
		this.user = user;
		this.shiftDetails = shiftDetails;
		this.seat = seat;
	}

}