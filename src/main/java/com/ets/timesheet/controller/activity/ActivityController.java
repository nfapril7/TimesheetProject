package com.ets.timesheet.controller.activity;

import com.ets.timesheet.message.request.CheckInForm;
import com.ets.timesheet.message.request.CheckOutForm;
import com.ets.timesheet.model.Activity;
import com.ets.timesheet.repository.activity.ActivityRepository;
import com.ets.timesheet.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
@PreAuthorize("hasRole('EMPLOYEE')")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @PostMapping("/checkIn")
    public Activity checkIn(@RequestBody CheckInForm formActivity) {
        return activityService.checkIn(formActivity);
    }
    
    @PostMapping("/checkOut")
    public Activity checOut(@RequestBody CheckOutForm formActivity) {
        return activityService.checkOut(formActivity);
    }

    @GetMapping("/upload") //ot, parkir
    public String uploadDoc() {
        return "//to be continue..";
    }

    @GetMapping("/request") //izin, cuti
    public String request() {
        return "//to be continue..";
    }
}
