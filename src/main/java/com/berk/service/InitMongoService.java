package com.berk.service;

import com.berk.domain.Account;
import com.berk.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.UUID;

/**
 * User: Oleg
 * Date: 09.12.13
 */
public class InitMongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void init() {
        // Drop existing collections
        mongoTemplate.dropCollection("role");
        mongoTemplate.dropCollection("account");

        // Create new records
        Role adminRole = new Role();
        adminRole.setId(UUID.randomUUID().toString());
        adminRole.setRole(1);

        Role accountRole = new Role();
        accountRole.setId(UUID.randomUUID().toString());
        accountRole.setRole(2);

        Account oleg = new Account();
        oleg.setId(UUID.randomUUID().toString());
        oleg.setUsername("Oleg");
        oleg.setPassword("pass");
        oleg.setRole(adminRole);

        Account ivanov = new Account();
        ivanov.setId(UUID.randomUUID().toString());
        ivanov.setUsername("Ivanov");
        ivanov.setPassword("hArDpAsSwOrD");
        ivanov.setRole(accountRole);

        // Insert to db
        mongoTemplate.insert(oleg, "account");
        mongoTemplate.insert(ivanov, "account");
        mongoTemplate.insert(adminRole, "role");
        mongoTemplate.insert(accountRole, "role");
    }
}
