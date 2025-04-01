package com.ticket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="BookTicket")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;
	 @NotBlank(message = "Source  name is required")
	 @Size(max = 200, message = "Source  name not exceed 20 characters")
	  @Column(nullable = false, length = 20)
	private String source;
	 @NotBlank(message = "destination  name is required")
	 @Size(max = 200, message = "destination  name not exceed 20 characters")
	  @Column(nullable = false, length = 20)
	private String destination;
	
	private int distance;
	
	private int cost;
	
	private String date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
}
