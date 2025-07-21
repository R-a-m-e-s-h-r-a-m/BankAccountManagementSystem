
package com.bank;

import com.bank.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    // No code needed, JpaRepository provides all CRUD methods
}
