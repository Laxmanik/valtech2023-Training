package com.valtech.team3.bookmyseat.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Floor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 20)
	private String floorName;
	@ManyToOne(targetEntity = Building.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "buildingId", referencedColumnName = "id", nullable = false)
	private Building building;
	@OneToMany(targetEntity = Seat.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "floor")
	private Set<Seat> seats;

	public Floor(int id, String floorName, Building building) {
		this.id = id;
		this.floorName = floorName;
		this.building = building;
	}

}
