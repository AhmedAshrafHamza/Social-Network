package com.project.Entity;
import javax.persistence.*;
@Entity
public class Data {
	private String  name;
	private String password;
	private String lastName;
	private String Location;
	private String Date;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String email;
	
	public Data()
	{
		name="";
		id=0;
		password="";
		email="";
		Location="";
		Date="";
		lastName="";
	}
public Data(String name, String password, int id,String email,String Date,String Location,String lastName) {
		super();
		this.name = name;
		this.password = password;
		this.id = id;
		this.email=email;
		this.Location=Location;
		this.Date=Date;
		this.lastName=lastName;
	}
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	


}
