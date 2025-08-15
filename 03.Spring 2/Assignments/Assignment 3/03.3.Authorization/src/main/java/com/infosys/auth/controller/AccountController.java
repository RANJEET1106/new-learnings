package com.infosys.auth.controller;

import com.infosys.auth.model.Account;
import com.infosys.auth.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping("/auth")
public class AccountController {
    @Autowired
    AccountRepo accountRepo;

    @PostMapping("/register")
    public Account registerAccount(@RequestBody Account account) {
        Account tempAccount = accountRepo.getAccountByEmail(account.getEmail());
        if (tempAccount != null) {
            throw new IllegalArgumentException("Account already exists");
        } else if (!account.getPassword().equals(account.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        else  {
            accountRepo.save(account);
            return account;
        }
    }

    @PostMapping("/login")
    public Account login(@RequestBody Account account) {
        Account tempAccount = accountRepo.getAccountByEmail(account.getEmail());
        if (tempAccount == null) {
            throw new IllegalArgumentException("Invalid email");
        }
        else if (!tempAccount.getPassword().equals(account.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return tempAccount;
    }

    @GetMapping("/{userId}")
    public Account getAccount(@PathVariable Long userId) {
        return accountRepo.findById(userId).get();
    }

}
