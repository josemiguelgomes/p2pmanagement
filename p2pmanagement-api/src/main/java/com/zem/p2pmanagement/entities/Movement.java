package com.zem.p2pmanagement.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "movement")
public class Movement extends AbstractEntity {

	@Column(name = "trans_date",            nullable = false)
	private Date transDate;
	@Column(name = "amount",                nullable = false)
	private Float amount;
	@Column(name = "currency",              nullable = false)
	private String currency;
	@Column(name = "description",           nullable = true)
	private String description;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
	@RestResource(exported=false)
	private Registration registration;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", nullable = true, updatable = false)
	@RestResource(exported=false)
	private Account account;	

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", nullable = true, updatable = false)
	@RestResource(exported=false)
	private Investaccount investaccount;	

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", nullable = true, updatable = false)
	@RestResource(exported=false)
	private Investment investment;	

	
	
	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Investaccount getInvestaccount() {
		return investaccount;
	}

	public void setInvestaccount(Investaccount investaccount) {
		this.investaccount = investaccount;
	}

	public Investment getInvestment() {
		return investment;
	}

	public void setInvestment(Investment investment) {
		this.investment = investment;
	}


	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Movement) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
