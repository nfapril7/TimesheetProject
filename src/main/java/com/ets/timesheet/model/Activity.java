/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ets.timesheet.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author april nf
 */
@Entity
@Table(name = "ACTIVITY")
@Data
@NoArgsConstructor
public class Activity {

    @Id
    @NotNull
    @Column
    private String id;
    
    @NotNull
    private Date activityDate;
    
    @NotNull
    private String startTime;
    
    @NotNull
    private String endTime;
    
    @NotNull
    private int totalTimes;
    
    @NotNull
    private String activity;
    
    @NotNull
    private char flag;

}
