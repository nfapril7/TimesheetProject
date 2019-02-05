package com.ets.timesheet.repository.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ets.timesheet.model.Account;
 
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
//    Optional<Account> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<Account> findByUsername(String username);

}
