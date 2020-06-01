package com.zem.p2pmanagement.entities;

import java.sql.Blob;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.zem.p2pmanagement.entities.AbstractEntity;

@Entity
@Table(name = "taxreport")
public class TaxReport extends AbstractEntity {

	@Column(name = "tax_year",   		nullable = false)
	private String taxYear;
	@Column(name = "tax_report", 		nullable = true)
	private Blob taxReport;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName="ID", nullable = false, updatable = false)
	@RestResource(exported=false)
	private Registration registration;


	public String getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}

	public Blob getTaxReport() {
		return taxReport;
	}

	public void setTaxReport(Blob taxReport) {
		this.taxReport = taxReport;
	}



	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((TaxReport) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
