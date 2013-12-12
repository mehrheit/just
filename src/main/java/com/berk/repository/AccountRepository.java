package com.berk.repository;

import com.berk.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: Oleg
 * Date: 09.12.13
 */
public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByUsername(String username);

}
