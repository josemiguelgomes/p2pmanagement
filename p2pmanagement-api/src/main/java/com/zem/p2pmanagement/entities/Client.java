package com.zem.p2pmanagement.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zem.p2pmanagement.entities.AbstractEntity;

@Entity
@Table(name = "client")
public class Client extends AbstractEntity {

	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name",  nullable = false)
	private String lastName;
	
	@OneToMany(mappedBy = "client")
	private Set<Registration> registration;
	
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
	
	public Set<Registration> getRegistration() {
		return registration;
	}
	public void setRegistration(Set<Registration> registration) {
		this.registration = registration;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Client) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
