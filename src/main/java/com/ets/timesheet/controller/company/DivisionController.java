package com.ets.timesheet.controller.company;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/division")
public class DivisionController {

	@GetMapping("/validate")
	public String activityEmployee() {
		return ">>> User Contents!";
	}
	
	@GetMapping("/check") //ot, parkir
	public String projectManagementAccess() {
		return ">>> Board Management Project";
	}
	
	@GetMapping("/datatable/activity") //izin, cuti
	public String adminAccess() {
		return ">>> Admin Contents";
	}
	
	@GetMapping("/datatable/others") //izin, cuti
	public String admin() {
		return ">>> Admin Contents";
	}
	
}
