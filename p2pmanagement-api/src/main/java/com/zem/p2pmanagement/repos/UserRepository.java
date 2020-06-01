package com.zem.p2pmanagement.repos;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zem.p2pmanagement.entities.User;
import com.zem.p2pmanagement.entities.projections.PartialUserProjection;

@RepositoryRestResource(collectionResourceRel = "users", path = "users", excerptProjection=PartialUserProjection.class)  // Projection to use by default
//public interface UserRepository extends CrudRepository<User, Long> {
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

//	List<User> findByFirstName(@Param("firstName") String firstName);
//	List<User> findByLastName(@Param("lastName") String lastName);

	Page<User> findByFirstName(@Param("firstName") String firstName, Pageable pageable);
	Page<User> findByLastName(@Param("lastName")   String lastName,  Pageable pageable);

	Page<User> findByFirstNameAndLastName(@Param("firstName") String firstName,
			                              @Param("lastName")  String lastName,
			                              Pageable pageable);
	
}
