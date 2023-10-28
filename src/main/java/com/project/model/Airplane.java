package com.project.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.swing.JSpinner.DateEditor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "AIRPLANE")
public class Airplane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String modelNumber;
	private Integer capacity;
	private Date createdAt;
	private Date updatedAt;
}
