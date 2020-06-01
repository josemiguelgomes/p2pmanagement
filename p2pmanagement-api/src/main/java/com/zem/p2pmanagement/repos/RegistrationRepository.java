package com.zem.p2pmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//import org.springframework.data.repository.CrudRepository;

import com.zem.p2pmanagement.entities.Registration;

@RepositoryRestResource(collectionResourceRel = "registrations", path = "registrations")
//public interface RegistrationRepository extends CrudRepository<Registration, Long> {
public interface RegistrationRepository extends PagingAndSortingRepository<Registration, Long> {

}
