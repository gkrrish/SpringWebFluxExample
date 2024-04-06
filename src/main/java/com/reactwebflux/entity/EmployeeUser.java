package com.reactwebflux.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String city;

	@Column(unique = true)
	private Long mobileNumber;

	@Column
	private int change;

	public EmployeeUser() {
	}

	public EmployeeUser(int id, String name, String city, Long mobileNumber, int change) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.mobileNumber = mobileNumber;
		this.change = change;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public int getChange() {
		return change;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setChange(int change) {
		this.change = change;
	}

	@Override
	public int hashCode() {
		return Objects.hash(change, city, id, mobileNumber, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeUser other = (EmployeeUser) obj;
		return change == other.change && Objects.equals(city, other.city) && id == other.id
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "EmployeeUser [id=" + id + ", name=" + name + ", city=" + city + ", mobileNumber=" + mobileNumber
				+ ", change=" + change + "]";
	}
}
