package com.valtech.team3.bookmyseat.entities;

import java.time.LocalDate;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 50)
	private String projectName;
	@Column(nullable = false)
	private LocalDate startDate;
	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime createdDate;
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime modifiedDate;
	@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	private Set<User> users;
	@OneToMany(targetEntity = RestrictedSeat.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	private Set<RestrictedSeat> restrictedSeats;

	public Project(int id, String projectName, LocalDate startDate, LocalDateTime createdDate) {
		this.id = id;
		this.projectName = projectName;
		this.startDate = startDate;
		this.createdDate = createdDate;
	}

}
