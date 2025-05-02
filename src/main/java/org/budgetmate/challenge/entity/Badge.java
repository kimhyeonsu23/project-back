package org.budgetmate.challenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "badge")
@Getter
@Setter
public class Badge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "badge_id")
	private Long badgeId;
	
	@Column(name = "badge_name", length = 45, nullable = false)
	private String badgeName;
	
	public Badge() {}

}
