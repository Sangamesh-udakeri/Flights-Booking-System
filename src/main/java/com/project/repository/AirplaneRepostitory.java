package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Airplane;

public interface AirplaneRepostitory extends JpaRepository<Airplane, Long> {

}
