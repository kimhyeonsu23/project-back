package me.khs.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "baget_history")
@Getter
@Setter
public class BadgeHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private Long historyId;
	
	@OneToOne
	@JoinColumn(name = "badge_id", nullable = false)
	private Badge badge;
	
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(nullable = false, name = "week_start_date")
	private LocalDate weekStartDate;
	
	@Column(nullable = false, name = "grated_date")
	private LocalDateTime grantedDate;
	
	
}
