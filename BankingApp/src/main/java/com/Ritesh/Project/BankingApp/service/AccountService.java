package com.Ritesh.Project.BankingApp.service;

import com.Ritesh.Project.BankingApp.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountdto);
    AccountDto getAccountById(Long id);
    AccountDto depositAmount(Long id, double amount);
    AccountDto withdrawAmount(Long id, Double amount);
    List<AccountDto> getAllAccounts();
    String deleteAccount(Long id);
}
