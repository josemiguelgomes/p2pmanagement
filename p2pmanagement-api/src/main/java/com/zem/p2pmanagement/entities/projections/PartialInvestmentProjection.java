package com.zem.p2pmanagement.entities.projections;

import org.springframework.data.rest.core.config.Projection;

import com.zem.p2pmanagement.entities.Investment;
import com.zem.p2pmanagement.entities.Registration;

@Projection(name = "partialInvestment", types = { Investment.class } )
public interface PartialInvestmentProjection {

	Float getInterestRate();
	
	Float getAmount();
	
	Integer getStatus();

	Registration getRegistration(); // expose hidden data
}
