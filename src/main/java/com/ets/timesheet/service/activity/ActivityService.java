/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ets.timesheet.service.activity;

import com.ets.timesheet.logic.ActivityLogic;
import com.ets.timesheet.message.request.CheckInForm;
import com.ets.timesheet.message.request.CheckOutForm;
import com.ets.timesheet.model.Activity;
import com.ets.timesheet.repository.activity.ActivityRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author april nf
 */
@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public Activity checkIn(CheckInForm checkIn) {
        Activity activity = activityRepository.findByAccountId(checkIn.getAccountId());
        if (activity == null) {
            activity = new Activity();
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = dateFormat.format(date);
            activity.setId(checkIn.getAccountId() + "" + strDate.replaceAll("/", ""));
            activity.setActivityDate(strDate);
            activity.setAccountId(checkIn.getAccountId());
            activity.setStartTime(date);
            activityRepository.save(activity);
        } else {
            //handling error has been check in
        }
        return activity;
    }

    public Activity checkOut(CheckOutForm checkOut) {
        Activity activity = null;
        if (checkOut != null) {
            activity = activityRepository.findByAccountId(checkOut.getAccountId());
            if (activity != null) {
                ActivityLogic logicAct = new ActivityLogic();
                Date date = new Date();
                activity.setEndTime(date);
                activity.setActivity(checkOut.getActivity());
                activity.setTotalTimes(logicAct.totalHours(activity.getStartTime(), new Date()));
                activity.setFlag(logicAct.flag(activity.getTotalTimes()));
                activityRepository.save(activity);
            } else {
                //handling error that employee not yet check in
            }
        }
        return activity;
    }

}
