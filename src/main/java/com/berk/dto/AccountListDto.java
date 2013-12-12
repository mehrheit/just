package com.berk.dto;

import com.berk.domain.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Oleg
 * Date: 09.12.13
 */
public class AccountListDto {
    private List<Account> accounts = new ArrayList<Account>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
