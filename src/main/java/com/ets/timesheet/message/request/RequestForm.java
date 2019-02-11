/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ets.timesheet.message.request;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author april nf
 */
@Data
@NoArgsConstructor
public class RequestForm {
    
    private int accountId;
    
    private Date startDate;
    
    private Date endDate;
    
    private String description;
    
    private String approvalHistory;
    
}
