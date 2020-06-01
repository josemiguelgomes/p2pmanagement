package com.zem.p2pmanagement.entities;

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

import com.zem.p2pmanagement.entities.AbstractEntity;

@Entity
@Table(name = "investment")
public class Investment extends AbstractEntity {

	@Column(name = "loan_id",                 nullable = false)
	private String loanId;
	@Column(name = "interest_rate",           nullable = false)
	private Double interestRate;
	@Column(name = "my_investment",           nullable = false)
	private Double myInvestment;
	@Column(name = "investment_date",         nullable = false)
	private Date investmentDate;
	@Column(name = "currency",                nullable = false)
	private String currency;
	@Column(name = "issue_date",              nullable = true)
	private Date issueDate;
	@Column(name = "loan_type",               nullable = true)
	private String loanType;
	@Column(name = "amortization_method",     nullable = true)
	private String amortizationMethod;
	@Column(name = "loan_originator",         nullable = true)
	private String loanOriginator;
	@Column(name = "rating",                  nullable = true)
	private String rating;
	@Column(name = "loan_amount",             nullable = true)
	private Double loanAmount;
	@Column(name = "remaining_principal",     nullable = true)
	private Double remainingPrincipal;
	@Column(name = "next_payment_date",       nullable = true)
	private Date nextPaymentDate;
	@Column(name = "estimated_next_payment",  nullable = true)
	private Double estimatedNextPayment;
	@Column(name = "itv",                     nullable = true)
	private String itv;
	@Column(name = "remaining_term",          nullable = true)
	private Long remainingTerm;
	@Column(name = "payments_received",       nullable = true)
	private Integer paymentsReceived;
	@Column(name = "status",                  nullable = true)
	private String status;
	@Column(name = "buyback_guarantee",       nullable = true)
	private Short buybackGuarantee;
	@Column(name = "schedule_extension",      nullable = true)
	private Short scheduleExtension;
	@Column(name = "received_payments",       nullable = true)
	private Double receivedPayments;
	@Column(name = "pending_payments",        nullable = true)
	private Double pendingPayments;
	@Column(name = "outstanding_principal",   nullable = true)
	private Double outstandingPrincipal;
	@Column(name = "secondary_market_amount", nullable = true)
	private Double secondaryMarketAmount;
	@Column(name = "price",                   nullable = true)
	private Double price;
	@Column(name = "discount_premium",        nullable = true)
	private Double discountPremium;



	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
	@RestResource(exported=false)
	private Registration registration;
	
	@OneToMany(mappedBy = "investment") // maps to variable "investment" on Registration Entity (not the database)
	private Set<Movement> movement;

	

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getMyInvestment() {
		return myInvestment;
	}

	public void setMyInvestment(Double myInvestment) {
		this.myInvestment = myInvestment;
	}

	public Date getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(Date investmentDate) {
		this.investmentDate = investmentDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getAmortizationMethod() {
		return amortizationMethod;
	}

	public void setAmortizationMethod(String amortizationMethod) {
		this.amortizationMethod = amortizationMethod;
	}

	public String getLoanOriginator() {
		return loanOriginator;
	}

	public void setLoanOriginator(String loanOriginator) {
		this.loanOriginator = loanOriginator;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getRemainingPrincipal() {
		return remainingPrincipal;
	}

	public void setRemainingPrincipal(Double remainingPrincipal) {
		this.remainingPrincipal = remainingPrincipal;
	}

	public Date getNextPaymentDate() {
		return nextPaymentDate;
	}

	public void setNextPaymentDate(Date nextPaymentDate) {
		this.nextPaymentDate = nextPaymentDate;
	}

	public Double getEstimatedNextPayment() {
		return estimatedNextPayment;
	}

	public void setEstimatedNextPayment(Double estimatedNextPayment) {
		this.estimatedNextPayment = estimatedNextPayment;
	}

	public String getItv() {
		return itv;
	}

	public void setItv(String itv) {
		this.itv = itv;
	}

	public Long getRemainingTerm() {
		return remainingTerm;
	}

	public void setRemainingTerm(Long remainingTerm) {
		this.remainingTerm = remainingTerm;
	}

	public Integer getPaymentsReceived() {
		return paymentsReceived;
	}

	public void setPaymentsReceived(Integer paymentsReceived) {
		this.paymentsReceived = paymentsReceived;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getBuybackGuarantee() {
		return buybackGuarantee;
	}

	public void setBuybackGuarantee(Short buybackGuarantee) {
		this.buybackGuarantee = buybackGuarantee;
	}

	public Short getScheduleExtension() {
		return scheduleExtension;
	}

	public void setScheduleExtension(Short scheduleExtension) {
		this.scheduleExtension = scheduleExtension;
	}

	public Double getReceivedPayments() {
		return receivedPayments;
	}

	public void setReceivedPayments(Double receivedPayments) {
		this.receivedPayments = receivedPayments;
	}

	public Double getPendingPayments() {
		return pendingPayments;
	}

	public void setPendingPayments(Double pendingPayments) {
		this.pendingPayments = pendingPayments;
	}

	public Double getOutstandingPrincipal() {
		return outstandingPrincipal;
	}

	public void setOutstandingPrincipal(Double outstandingPrincipal) {
		this.outstandingPrincipal = outstandingPrincipal;
	}

	public Double getSecondaryMarketAmount() {
		return secondaryMarketAmount;
	}

	public void setSecondaryMarketAmount(Double secondaryMarketAmount) {
		this.secondaryMarketAmount = secondaryMarketAmount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPremium() {
		return discountPremium;
	}

	public void setDiscountPremium(Double discountPremium) {
		this.discountPremium = discountPremium;
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
		return Objects.equals(id, ((Investment) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
