package com.zem.p2pmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//import org.springframework.data.repository.CrudRepository;

import com.zem.p2pmanagement.entities.Investment;

@RepositoryRestResource(collectionResourceRel = "investments", path = "investments")
//public interface InvestmentRepository extends CrudRepository<Investment, Long> {
public interface InvestmentRepository extends PagingAndSortingRepository<Investment, Long> {

}
