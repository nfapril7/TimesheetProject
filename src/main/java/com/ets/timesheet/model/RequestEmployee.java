/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ets.timesheet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "REQUEST_EMPLOYEE")
@Data
@NoArgsConstructor
public class RequestEmployee {

    @Id
    @NotNull
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @NotNull
    private int accountId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;
        
    private int totalDays;
    
    private String description;
    
    private String approvalHistory;
}
