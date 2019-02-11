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

    private int totalTimes;

    private char flag;

    public int totalHours(Date start, Date end) {
        long seconds = 1000;
        long minutes = seconds * 60;
        long hours = minutes * 60;
        long totalHours = end.getTime() - start.getTime();

        long days = hours * 24;

        long elapsedDays = totalHours / days;
        totalHours = totalHours % days;

        long elapsedHours = totalHours / hours;
        totalHours = totalHours % hours;

        long elapsedMinutes = totalHours / minutes;
        totalHours = totalHours % minutes;

        long elapsedSeconds = totalHours / seconds;

        //+ ", " + elapsedMinutes + ", " + elapsedSeconds
        totalTimes = (int) elapsedHours;
        System.out.println("total "+elapsedHours);
        return totalTimes;
    }

    public char flag(int totalTimes) {
        if (totalTimes >= 8) {
            flag = 'H';
        } else {
            flag = 'T';
        }
        return flag;
    }

}
