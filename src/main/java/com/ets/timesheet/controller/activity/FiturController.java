/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ets.timesheet.controller.activity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author april nf
 */

@RestController
@RequestMapping("/fitur")
public class FiturController {

    @GetMapping("notification")
    public String notification() {
        //if < 8 jam send email
        //if lupa tap out send email
        //scheduler
        //to be continue
        return "";
    }
}
