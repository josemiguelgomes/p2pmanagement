package com.zem.p2pmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zem.p2pmanagement.controllers.exceptions.InvestmentAlreadyTerminated;
import com.zem.p2pmanagement.entities.Investment;
import com.zem.p2pmanagement.repos.InvestmentRepository;

@RepositoryRestController
@RequestMapping("/investments")
@CrossOrigin
public class P2PManageInvestmentController {

	@Autowired
    private InvestmentRepository investmentRepository;
    
	@PostMapping("/terminate/{id}")
//	public ResponseEntity terminateInvestment(@PathVariable Long id) {
	public ResponseEntity<PersistentEntityResource> terminateInvestment(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
	  
		// get investment
		Optional <Investment> investmentOpt = investmentRepository.findById(id);
		if (!investmentOpt.isPresent()) {
			throw new ResourceNotFoundException("Investment " + id + " does not exist");
		}
	
		// get investment
		Investment investment = investmentOpt.get();
		
//		// check if investment status is "CURRENT"
		if (investment.getStatus() == "CURRENT") {
			throw new InvestmentAlreadyTerminated();
		}
	
		// set investment status to "TERMINATED"
		investment.setStatus("TERMINATED");
	
		// save the repository to the database
		investmentRepository.save(investment);
		
		// return a Response
//		return ResponseEntity.ok();
//		return ResponseEntity.ok(assembler.toModel(investment));
		return ResponseEntity.ok(assembler.toFullResource(investment));
	}

}
