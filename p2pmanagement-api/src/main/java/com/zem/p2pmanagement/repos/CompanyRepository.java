package com.zem.p2pmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//import org.springframework.data.repository.CrudRepository;

import com.zem.p2pmanagement.entities.Company;

@RepositoryRestResource(collectionResourceRel = "companies", path = "companies")
//public interface CompanyRepository extends CrudRepository<Company, Long> {
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

}
