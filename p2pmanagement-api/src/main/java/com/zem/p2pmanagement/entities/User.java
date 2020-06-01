package com.zem.p2pmanagement.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zem.p2pmanagement.entities.AbstractEntity;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

	@Column(name = "userid",     nullable = false)
	private String userid;
	@Column(name = "password",   nullable = true)
	private String password;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name",  nullable = true)
	private String lastName;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((User) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
