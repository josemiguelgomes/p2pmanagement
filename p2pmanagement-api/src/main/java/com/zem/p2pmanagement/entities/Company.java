package com.zem.p2pmanagement.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends AbstractEntity {

	@Column(name = "name",       nullable = false)
	private String name;
	@Column(name = "url",        nullable = true)
	private String url;
	@Column(name = "contact",    nullable = true)	
	private String contact;
	@OneToMany(mappedBy = "company") // maps to variable "company" on Registration Entity (not the database)
	private Set<Registration> registration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}

	public Set<Registration> getRegistration() {
		return registration;
	}

	public void setRegistration(Set<Registration> registration) {
		this.registration = registration;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Company) obj).id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
