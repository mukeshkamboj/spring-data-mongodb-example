package com.persistence.entity;

import org.springframework.data.annotation.Id;

public class Persistence {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
