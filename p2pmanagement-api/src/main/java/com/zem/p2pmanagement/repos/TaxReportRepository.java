package com.zem.p2pmanagement.repos;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zem.p2pmanagement.entities.TaxReport;

@RepositoryRestResource(collectionResourceRel = "taxreports", path = "taxreports")
public interface TaxReportRepository extends PagingAndSortingRepository<TaxReport, Long> {

	
}
