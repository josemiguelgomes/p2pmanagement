package com.zem.p2pmanagement.repos;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zem.p2pmanagement.entities.Client;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
//public interface ClientRepository extends CrudRepository<Client, Long> {
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

	/*
	// Security at method Level : only the Role ADMIN can do delete()
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Client client);
	*/
}
