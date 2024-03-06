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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 5, unique = true)
	private int employeeId;
	@Column(nullable = false, length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(nullable = false, length = 50, unique = true)
	private String email;
	private long phoneNumber;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, columnDefinition = "BIT DEFAULT false")
	private boolean status;
	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime createdDate;
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime modifiedDate;
	@ManyToOne(targetEntity = Project.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId", referencedColumnName = "id", nullable = false)
	private Project project;
	@ManyToOne(targetEntity = Role.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", referencedColumnName = "id", nullable = false)
	private Role role;
	@OneToOne(targetEntity = RestrictedSeat.class, mappedBy = "user")
	private RestrictedSeat restrictedSeat;

	public User(int id, int employeeId, String firstName, String lastName, String email, long phoneNumber, String password, boolean status, LocalDateTime createdDate, Project project, Role role) {
		this.id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.status = status;
		this.createdDate = createdDate;
		this.project = project;
		this.role = role;
	}

}
