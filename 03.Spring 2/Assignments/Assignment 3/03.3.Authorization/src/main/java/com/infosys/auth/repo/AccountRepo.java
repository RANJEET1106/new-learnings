package com.infosys.auth.repo;

import com.infosys.auth.model.Account;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Account getAccountByEmail (String email);
}
