package com.Ritesh.Project.BankingApp.mapper;

import com.Ritesh.Project.BankingApp.dto.AccountDto;
import com.Ritesh.Project.BankingApp.entity.Accounts;

public class AccountMapper {

    public static Accounts mapToAccount(AccountDto accountdto){
        Accounts account = new Accounts(
                accountdto.getId(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()

        );

        return account;
    }

    public static AccountDto mapToAccountDto(Accounts account){
        AccountDto accountdto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        return accountdto;
    }
}
