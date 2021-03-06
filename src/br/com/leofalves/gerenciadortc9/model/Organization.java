package br.com.leofalves.gerenciadortc9.model;

import java.util.Date;

public class Organization {
	private Integer id;
	private String name;
	private Date openingDate = new Date();
	
	
	public Organization() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	
}
