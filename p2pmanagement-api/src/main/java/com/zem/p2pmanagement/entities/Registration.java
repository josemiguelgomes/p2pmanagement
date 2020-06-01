package com.zem.p2pmanagement.entities;

//import java.sql.Blob;
import java.util.Date;
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
@Table(name = "registration")
public class Registration extends AbstractEntity {

	@Column(name = "company_client_id",          nullable = false)
	private String companyClientId;
	@Column(name = "date_created",               nullable = true)
	private Date dateCreated;
	@Column(name = "userid",                     nullable = true)
	private String userid;
	@Column(name = "password",                   nullable = true)
	private String password;
	@Column(name = "two_factor_auth",            nullable = true)	
	private String twoFactorAuth;
	@Column(name = "city",                       nullable = true)
	private String city;
	@Column(name = "address",                    nullable = true)
	private String address;
	@Column(name = "postal_code",                nullable = true)
	private String postalCode;
	@Column(name = "residence_country",          nullable = true)
	private String residenceCountry;
	@Column(name = "phone",                      nullable = true)
	private String phone;
	@Column(name = "email",                      nullable = true)
	private String email;
	@Column(name = "language",                   nullable = true)
	private String language; 
	@Column(name = "document",                   nullable = true)
	private String document;
	@Column(name = "contact",                    nullable = true)
	private String contact;
	@Column(name = "notif_daily_summary",        nullable = true)
	private Boolean notifDailySummary;
	@Column(name = "notif_deposits",             nullable = true)
	private Boolean notifDeposits;
	@Column(name = "notif_successful_withdrawl", nullable = true)
	private Boolean notifSuccessfulWithdrawl;
	@Column(name = "notif_bonus_payment",        nullable = true)
	private Boolean notifBonusPayment;
	@Column(name = "notif_newsletters",          nullable = true)
	private Boolean notifNewsletters;
//	@Column(name = "agreement",                  nullable = true)
//	private Blob agreement;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
	@RestResource(exported=false)
	private Client client;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
	@RestResource(exported=false)
	private Company company;
	
	@OneToMany(mappedBy = "registration") 		// maps to variable "registration" on Account Entity (not the database)
	private Set<Account> account;	

	@OneToMany(mappedBy = "registration")		// maps to variable "registration" on Investaccount Entity (not the database)
	private Set<Investaccount> investaccount;	

	@OneToMany(mappedBy = "registration")		// maps to variable "registration" on Investment Entity (not the database)
	private Set<Investment> investment;	
	
	@OneToMany(mappedBy = "registration")		// maps to variable "registration" on TaxReport Entity (not the database)
	private Set<TaxReport> taxReport;	

	@OneToMany(mappedBy = "registration")		// maps to variable "registration" on Movement Entity (not the database)
	private Set<Movement> movement;	
	
	
	public String getCompanyClientId() {
		return companyClientId;
	}

	public void setCompanyClientId(String companyClientId) {
		this.companyClientId = companyClientId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

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

	public String getTwoFactorAuth() {
		return twoFactorAuth;
	}

	public void setTwoFactorAuth(String twoFactorAuth) {
		this.twoFactorAuth = twoFactorAuth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getResidenceCountry() {
		return residenceCountry;
	}

	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Boolean getNotifDailySummary() {
		return notifDailySummary;
	}

	public void setNotifDailySummary(Boolean notifDailySummary) {
		this.notifDailySummary = notifDailySummary;
	}

	public Boolean getNotifDeposits() {
		return notifDeposits;
	}

	public void setNotifDeposits(Boolean notifDeposits) {
		this.notifDeposits = notifDeposits;
	}

	public Boolean getNotifSuccessfulWithdrawl() {
		return notifSuccessfulWithdrawl;
	}

	public void setNotifSuccessfulWithdrawl(Boolean notifSuccessfulWithdrawl) {
		this.notifSuccessfulWithdrawl = notifSuccessfulWithdrawl;
	}

	public Boolean getNotifBonusPayment() {
		return notifBonusPayment;
	}

	public void setNotifBonusPayment(Boolean notifBonusPayment) {
		this.notifBonusPayment = notifBonusPayment;
	}

	public Boolean getNotifNewsletters() {
		return notifNewsletters;
	}

	public void setNotifNewsletters(Boolean notifNewsletters) {
		this.notifNewsletters = notifNewsletters;
	}

//	public Blob getAgreement() {
//		return agreement;
//	}
//
//	public void setAgreement(Blob agreement) {
//		this.agreement = agreement;
//	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public Set<Investaccount> getInvestaccount() {
		return investaccount;
	}

	public void setInvestaccount(Set<Investaccount> investaccount) {
		this.investaccount = investaccount;
	}

	public Set<Investment> getInvestment() {
		return investment;
	}

	public void setInvestment(Set<Investment> investment) {
		this.investment = investment;
	}

	public Set<TaxReport> getTaxReport() {
		return taxReport;
	}

	public void setTaxReport(Set<TaxReport> taxReport) {
		this.taxReport = taxReport;
	}

	public Set<Movement> getMovement() {
		return movement;
	}

	public void setMovement(Set<Movement> movement) {
		this.movement = movement;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Registration) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
