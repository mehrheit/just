package com.berk.repository;

import com.berk.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: Oleg
 * Date: 09.12.13
 */
public interface RoleRepository extends MongoRepository<Role, String> {

}
