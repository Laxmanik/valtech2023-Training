package com.valtech.team3.bookmyseat.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Building {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 50)
	private String buildingName;
	@Column(nullable = false, length = 50)
	private String locationName;
	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime createdDate;
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime modifiedDate;
	@OneToMany(targetEntity = Floor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "building")
	private Set<Floor> floors;

	public Building(int id, String buildingName, String locationName, LocalDateTime createdDate) {
		this.id = id;
		this.buildingName = buildingName;
		this.locationName = locationName;
		this.createdDate = createdDate;
	}
}
