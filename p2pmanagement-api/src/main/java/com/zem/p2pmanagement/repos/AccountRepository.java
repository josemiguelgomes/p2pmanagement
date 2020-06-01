package com.zem.p2pmanagement.repos;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zem.p2pmanagement.entities.Account;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
//public interface AccountRepository extends CrudRepository<Account, Long> {
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findByAccount(@Param("account") String account);
    List<Account> findByCurrency(@Param("currency") String currency);
//    List<Account> findByRegistration(@Param("registration") Registration registration);
   
}
