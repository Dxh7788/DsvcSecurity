package org.otk.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -1160808677268207777L;
	private Integer number;
	private String id;
	private String name;
	private Address address;
	public User() {
	}
	public User(Integer number, String id) {
		this.number = number;
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [number=" + number + ", id=" + id + "]";
	}
}
