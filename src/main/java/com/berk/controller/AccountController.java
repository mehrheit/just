package com.berk.controller;

import com.berk.domain.Account;
import com.berk.domain.Role;
import com.berk.dto.AccountListDto;
import com.berk.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User: Oleg
 * Date: 18.11.13
 */
@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping
    public String getAccountsPage(){
        return "accounts";
    }

    @RequestMapping(value = "/records")
    public @ResponseBody
    AccountListDto getAccounts(){
        AccountListDto accountListDto = new AccountListDto();
        accountListDto.setAccounts(accountService.getAllAccounts());
        return accountListDto;
    }

    @RequestMapping(value = "/getAccount")
    public @ResponseBody
    Account getAccount(@RequestBody Account account){
        return accountService.read(account);
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public @ResponseBody Account createAccount(
            @RequestParam String id,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String username,
            @RequestParam String birthday,
            @RequestParam String location,
            @RequestParam String photo,
            @RequestParam String about,
            @RequestParam Integer role) {

        Role newRole = new Role();
        newRole.setRole(role);
        Account newAccount = new Account();
        newAccount.setEmail(email);
        newAccount.setUsername(username);
        return accountService.create(newAccount);
    }
    @RequestMapping(value="/update", method= RequestMethod.POST)
    public @ResponseBody Account updateAccount(
            @RequestParam String username,
            @RequestParam Integer role) {

        Role existingRole = new Role();
        existingRole.setRole(role);
        Account existingAccount = new Account();
        existingAccount.setUsername(username);
        existingAccount.setRole(existingRole);
        return accountService.update(existingAccount);
    }
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public @ResponseBody Boolean deleteAccount(
            @RequestParam String username) {

        Account existingUser = new Account();
        existingUser.setUsername(username);
        return accountService.delete(existingUser);
    }



}
