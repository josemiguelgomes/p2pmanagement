package com.zem.p2pmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//mport org.springframework.data.repository.CrudRepository;

import com.zem.p2pmanagement.entities.Investaccount;

@RepositoryRestResource(collectionResourceRel = "investaccount", path = "investaccount")
//public interface InvestaccountRepository extends CrudRepository<Investaccount, Long> {
public interface InvestaccountRepository extends PagingAndSortingRepository<Investaccount, Long> {

}
