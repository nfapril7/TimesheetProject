/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ets.timesheet.message.request;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author april nf
 */
@Data
@NoArgsConstructor
public class CheckOutForm {
               
   
    @NotBlank
    private int accountId;
    
    @NotBlank
    @Size(min=1)
    private String activity;
}
