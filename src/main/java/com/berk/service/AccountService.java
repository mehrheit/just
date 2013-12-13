package com.berk.service;

import com.berk.domain.Account;
import com.berk.repository.AccountRepository;
import com.berk.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * User: Oleg
 * Date: 07.12.13
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Account create(Account account) {
        account.setId(UUID.randomUUID().toString());
        account.getRole().setId(UUID.randomUUID().toString());

        roleRepository.save(account.getRole());
        return accountRepository.save(account);
    }

    public Account read(Account account) {
        return account;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account update(Account account) {
        Account existingAccount = accountRepository.findByUsername(account.getUsername());
        if (existingAccount == null) {
            return null;
        }

        existingAccount.setUsername(account.getUsername());
        existingAccount.getRole().setRole(account.getRole().getRole());

//        System.out.println("Here name: " + account.getUsername());
        roleRepository.save(existingAccount.getRole());
        return accountRepository.save(existingAccount);
    }

    public Boolean delete(Account account) {
        Account existingAccount = accountRepository.findByUsername(account.getUsername());

        if (existingAccount == null) {
            return false;
        }

        roleRepository.delete(existingAccount.getRole());
        accountRepository.delete(existingAccount);
        return true;
    }
}
