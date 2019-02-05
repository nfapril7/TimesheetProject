package com.ets.timesheet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUTH")
@Data
@NoArgsConstructor
public class Auth {

	@Id
	@NotNull
	@Column(name = "token")
	private String token;

	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name ="loginDate")
	private Date loginDate;
	
	@NotNull
	@Column(name = "expiredLogin")
	private Date expLogin;
	
}
