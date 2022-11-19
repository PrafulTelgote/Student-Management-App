package com.school.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,unique = true)
	private String mobile;
	
	@Column(nullable = false,unique = true)
	private String Email;
	
	private String Password;
	
	@Embedded
	private Address address;

	private String role;
}
