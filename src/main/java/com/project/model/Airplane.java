package com.project.model;

import java.security.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JSpinner.DateEditor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "AIRPLANE")
public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelNumber;
	private int capacity;
	private LocalDate createdAt; 
	@Column(name = "updatedAt")
	private LocalDate updatedAt; 
	
}
