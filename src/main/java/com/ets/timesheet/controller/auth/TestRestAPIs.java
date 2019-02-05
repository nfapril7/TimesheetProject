package com.ets.timesheet.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/employee")
	@PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
	public String userAccess() {
		return "//to be continue..";
	}
	
	@GetMapping("/api/test/pic")
	@PreAuthorize("hasRole('PIC') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return "//to be continue..";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "//to be continue..";
	}
}
