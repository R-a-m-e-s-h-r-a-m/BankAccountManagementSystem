package com.bank;

import com.bank.BankAccount;
import com.bank.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository repository;

    public String createAccount(String accountNumber, String accountHolder) {
        if (repository.existsById(accountNumber)) {
            return "Account number already exists.";
        }
        BankAccount account = new BankAccount(accountNumber, accountHolder);
        repository.save(account);
        return "Account created successfully.";
    }

    public String deposit(String accountNumber, double amount) {
        Optional<BankAccount> accountOpt = repository.findById(accountNumber);
        if (accountOpt.isPresent()) {
            BankAccount account = accountOpt.get();
            account.deposit(amount);
            repository.save(account);
            return "Deposited: " + amount;
        }
        return "Account not found.";
    }

    public String withdraw(String accountNumber, double amount) {
        Optional<BankAccount> accountOpt = repository.findById(accountNumber);
        if (accountOpt.isPresent()) {
            BankAccount account = accountOpt.get();
            if (amount > 0 && amount <= account.getBalance()) {
                account.withdraw(amount);
                repository.save(account);
                return "Withdrawn: " + amount;
            }
            return "Invalid withdrawal amount.";
        }
        return "Account not found.";
    }

    public Optional<BankAccount> getAccount(String accountNumber) {
        return repository.findById(accountNumber);
    }

    public String removeAccount(String accountNumber) {
        if (repository.existsById(accountNumber)) {
            repository.deleteById(accountNumber);
            return "Account removed successfully.";
        }
        return "Account not found.";
    }
}
