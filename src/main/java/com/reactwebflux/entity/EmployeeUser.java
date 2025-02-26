package com.reactwebflux.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Table("employee_user")
public class EmployeeUser {
	@Schema(hidden = true) // because, if we show id in the postman/swagger, makes confusion because r2db,
							// if he see id in the request body, he thinks, id validation do, though already
							// id there, so gives the error and wont save the record
	@Id
	private int id;

	@Column
	private String name;

	@Column
	private String city;

	@Column("mobile_number")
	private Long mobileNumber;

	@Column
	private int change;

	public EmployeeUser() {
	}

	public EmployeeUser(String name, String city, Long mobileNumber, int change) {
		this.name = name;
		this.city = city;
		this.mobileNumber = mobileNumber;
		this.change = change;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	@Override
	public String toString() {
		return "EmployeeUser{" + "id=" + id + ", name='" + name + '\'' + ", city='" + city + '\'' + ", mobileNumber="
				+ mobileNumber + ", change=" + change + '}';
	}
}
