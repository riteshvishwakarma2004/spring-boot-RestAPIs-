package com.Ritesh.Project.BankingApp.controller;

import com.Ritesh.Project.BankingApp.dto.AccountDto;
import com.Ritesh.Project.BankingApp.service.AccountService;
import com.Ritesh.Project.BankingApp.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountServiceImpl accountService;
    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    //Api to create an account
    @PostMapping("/account")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }

    //api to fetch an account
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("id") Long id){
        AccountDto fetchedAccount = accountService.getAccountById(id);
        return ResponseEntity.ok(fetchedAccount);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable("id") Long id, @RequestBody Map<String, Double> request){
       AccountDto accountDto =  accountService.depositAmount(id , request.get("amount"));
       return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withDraw(@PathVariable("id") Long id, @RequestBody Map<String,Double> request){
        AccountDto accountDto = accountService.withdrawAmount(id, request.get("withDraw"));

        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("accounts")
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id){
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }
}
