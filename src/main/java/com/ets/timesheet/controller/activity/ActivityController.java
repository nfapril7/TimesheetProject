package com.ets.timesheet.controller.activity;

import com.ets.timesheet.message.request.ActivityForm;
import com.ets.timesheet.model.Activity;
import com.ets.timesheet.repository.activity.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
@PreAuthorize("hasRole('EMPLOYEE')")
public class ActivityController {

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping("/today")
    public Activity activityToday(@RequestBody ActivityForm formActivity) {
        Activity activity = new Activity();
        activity.setActivityDate(formActivity.getActivityDate());
        activity.setFlag(formActivity.getFlag());
        activityRepository.save(activity);
        //to be continue..
        return activity;
    }

    @GetMapping("/others") //ot, parkir
    public String projectManagementAccess() {
        return "//to be continue..";
    }

    @GetMapping("/request") //izin, cuti
    public String adminAccess() {
        return "//to be continue..";
    }

}
