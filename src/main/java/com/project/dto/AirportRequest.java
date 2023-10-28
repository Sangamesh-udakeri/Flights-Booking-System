package com.project.dto;

import lombok.Data;

@Data
public class AirportRequest {

	private String name;
	private String address;
	private String code;
	private Long cityId;

}
