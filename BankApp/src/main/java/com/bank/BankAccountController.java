package com.bank;

import com.bank.BankAccount;
import com.bank.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService service;

    @PostMapping("/create")
    public String createAccount(@RequestParam String accountNumber, @RequestParam String accountHolder) {
        return service.createAccount(accountNumber, accountHolder);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNumber, @RequestParam double amount) {
        return service.deposit(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
        return service.withdraw(accountNumber, amount);
    }

    @GetMapping("/details")
    public Optional<BankAccount> getDetails(@RequestParam String accountNumber) {
        return service.getAccount(accountNumber);
    }

    @DeleteMapping("/remove")
    public String removeAccount(@RequestParam String accountNumber) {
        return service.removeAccount(accountNumber);
    }
}
