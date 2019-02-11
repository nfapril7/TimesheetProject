/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ets.timesheet.repository.activity;

import com.ets.timesheet.model.Account;
import com.ets.timesheet.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author april nf
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {
    
    @Query("SELECT u FROM Activity u where accountId = ?1 and activityDate = convert(varchar, getdate(), 103) ")
    public Activity findByAccountId(int accountId);
}
