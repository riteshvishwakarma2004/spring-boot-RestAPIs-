package com.Ritesh.Project.BankingApp.service;

import com.Ritesh.Project.BankingApp.dto.AccountDto;
import com.Ritesh.Project.BankingApp.entity.Accounts;
import com.Ritesh.Project.BankingApp.mapper.AccountMapper;
import com.Ritesh.Project.BankingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountdto) {
        Accounts account = AccountMapper.mapToAccount(accountdto);
        Accounts savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Accounts fetchedAccount = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));

        return AccountMapper.mapToAccountDto(fetchedAccount);
    }

    @Override
    public AccountDto depositAmount(Long id, double amount) {
        Accounts account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("account not found"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
       Accounts savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdrawAmount(Long id, Double withDraw) {
        Accounts updatedAccount = null;
        Accounts account = accountRepository.findById(id).orElse(new Accounts());

        if(account.getAccountHolderName() == null && account.getBalance() == 0){
            return AccountMapper.mapToAccountDto(account);
        }else{
            double balance = account.getBalance();
            if(balance <= withDraw){
                return new AccountDto();
            }else{
                double total = balance - withDraw;
                account.setBalance(total);
                updatedAccount = accountRepository.save(account);
            }
        }

        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<AccountDto> allAccountDto = new ArrayList<>();
        List<Accounts> allAccounts = accountRepository.findAll();
        for(Accounts account: allAccounts){
            allAccountDto.add(AccountMapper.mapToAccountDto(account));
        }

        return allAccountDto;
    }

    @Override
    public String deleteAccount(Long id) {
        Optional<Accounts> account = accountRepository.findById(id);
        if(account.isEmpty()){
            return "account does not exist";
        }
        accountRepository.deleteById(id);
        return "Account Deleted Successfully";
    }


}
