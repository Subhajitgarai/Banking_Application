package com.bank.controller;

import com.bank.payloads.CustomerDto;
import com.bank.security.JWTRequest;
import com.bank.security.JWTResponse;
import com.bank.security.JwtHelper;
import com.bank.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtHelper helper;
    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    //Methode for login
    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {
        //Checking User is Valid Or not
        this.doAuthenticate(request.getEmail(), request.getPassword());
        //If Valid then getting the user details for token
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);

        JWTResponse response = JWTResponse.builder()
                .jwtToken(token)
                .useername(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //Methode to validate the email and password
    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {

            daoAuthenticationProvider.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Password not matched for user "+ email);
        }

    }
    //If Any Exception Occurs it will come here and print this
    //Register New User Api
    // Test For Revert
    @PostMapping("/register/{branchCode}")
    public ResponseEntity<CustomerDto>registerUser(@RequestBody CustomerDto customerDto,@PathVariable int branchCode){
        CustomerDto registered = customerService.createNewCustomer(customerDto, branchCode);
        return new ResponseEntity<>(registered,HttpStatus.CREATED);
    }


}
