package com.ets.timesheet.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ets.timesheet.model.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth, String>  {

}
