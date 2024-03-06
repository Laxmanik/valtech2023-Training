package com.valtech.team3.bookmyseat.entities;

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
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true, length = 20)
	private String roleName;
	@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<User> users;

	public Role(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

}
