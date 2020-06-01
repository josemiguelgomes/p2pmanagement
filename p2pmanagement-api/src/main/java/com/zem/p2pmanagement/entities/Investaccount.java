package com.zem.p2pmanagement.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "investaccount")
public class Investaccount extends AbstractEntity {

	@Column(name = "currency",       nullable = false)
	private String currency;
	@Column(name = "balance",        nullable = false)
	private Float balance;
	@Column(name = "description",    nullable = true)
	private String description;


	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName="ID", nullable = false, updatable = false)
	@RestResource(exported=false)
	private Registration registration;
	
	@OneToMany(mappedBy = "investaccount") 		// maps to variable "investaccount" on Movement Entity (not the database)
	private Set<Movement> movement;


	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Set<Movement> getMovement() {
		return movement;
	}

	public void setMovement(Set<Movement> movement) {
		this.movement = movement;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Investaccount) obj).id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
