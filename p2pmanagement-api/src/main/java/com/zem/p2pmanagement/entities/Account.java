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

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// @JsonPropertyOrder({"resourceId"})  EXAMPLE
@Entity
@Table(name = "account")
public class Account extends AbstractEntity {

//	@JsonProperty("Conta")  // rename field on JSON, EXAMPLE
	@Column(name = "account",    nullable = false)
	private String account;
	@Column(name = "currency",   nullable = true)
	private String currency;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName="ID", nullable = false, updatable = false)
	@RestResource(exported=false)
	private Registration registration;
	
	@OneToMany(mappedBy = "account")
	private Set<Movement> movement;
	
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
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
		return Objects.equals(id, ((Account) obj).id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
