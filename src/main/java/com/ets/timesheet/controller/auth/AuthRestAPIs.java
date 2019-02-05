package com.ets.timesheet.controller.auth;

import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ets.timesheet.config.JwtProvider;
import com.ets.timesheet.message.request.LoginForm;
import com.ets.timesheet.message.request.SignUpForm;
import com.ets.timesheet.message.response.JwtResponse;
import com.ets.timesheet.model.Account;
import com.ets.timesheet.model.AccountRole;
import com.ets.timesheet.model.Role;
import com.ets.timesheet.repository.auth.AccountRepository;
import com.ets.timesheet.repository.auth.AuthRepository;
import com.ets.timesheet.repository.auth.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
    private static final Logger logger = LoggerFactory.getLogger(AuthRestAPIs.class);
   
    @Autowired
    AuthenticationManager authenticationManager;
 
    @Autowired
    AccountRepository userRepository;
 
    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    AuthRepository authRepository;
 
    @Autowired
    PasswordEncoder encoder;
 
    @Autowired
    JwtProvider jwtProvider;
 
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        ); 
        SecurityContextHolder.getContext().setAuthentication(authentication); 
        String jwt = jwtProvider.generateJwtToken(authentication);        
        return ResponseEntity.ok(new JwtResponse(jwt, authentication.getName(),
                authentication.getAuthorities()));
    }
 
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            logger.warn("Username "+signUpRequest.getUsername()+" is already taken!");
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            logger.warn("Email "+signUpRequest.getEmail()+" is already in use!");
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        Account user = new Account();
        user.setAccountId(signUpRequest.getAccountId());
        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
 
        strRoles.forEach(role -> {
        	switch(role) {
	    		case "admin":
	    			Role adminRole = roleRepository.findByRoleName(AccountRole.ROLE_ADMIN)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	    			roles.add(adminRole);
	    			
	    			break;
	    		case "pic":
	            	Role pmRole = roleRepository.findByRoleName(AccountRole.ROLE_PIC_DIVISION)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	            	roles.add(pmRole);
	            	
	    			break;
	    		default:
	        		Role userRole = roleRepository.findByRoleName(AccountRole.ROLE_EMPLOYEE)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        		roles.add(userRole);        			
        	}
        });
        
        user.setRoles(roles);
        userRepository.save(user);
        logger.info("User registered successfully");
        return ResponseEntity.ok().body("User registered successfully!");
    }
}