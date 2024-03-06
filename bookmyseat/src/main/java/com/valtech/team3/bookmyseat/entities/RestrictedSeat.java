package com.valtech.team3.bookmyseat.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RestrictedSeat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(targetEntity = Seat.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restrictedSeat")
	private Seat seat;
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	@ManyToOne(targetEntity = Project.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId", referencedColumnName = "id")
	private Project project;
	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime createdDate;
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime modifiedDate;

	public RestrictedSeat(int id, Seat seat, User user, Project project, LocalDateTime createdDate) {
		this.id = id;
		this.seat = seat;
		this.user = user;
		this.project = project;
		this.createdDate = createdDate;
	}

}
