package com.Ritesh.Project.BankingApp.repository;

import com.Ritesh.Project.BankingApp.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, Long> {
}
