/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ets.timesheet.logic;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author april nf
 */
@Getter
@Setter
public class ActivityLogic {
    
    private String id;
    
    private String start, end;
    
    private int totalHours;
    
    private Date activityDate;

   
    
}
