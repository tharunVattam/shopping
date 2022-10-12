package com.fse.shoppingapp.controller;

import com.fse.shoppingapp.exception.GlobalExceptionHandler;
import com.fse.shoppingapp.model.Customer;
import com.fse.shoppingapp.model.CustomerData;
import com.fse.shoppingapp.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class LoginController {

    Logger logger = LogManager.getLogger(LoginController.class);


    @Autowired
    private LoginService loginService;

    @PostMapping ("/register")
    public ResponseEntity<Customer>  register(@RequestBody Customer customer){
        Customer response = loginService.registerCustomer(customer);
        ResponseEntity<Customer> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping ("/login")
    public ResponseEntity<Customer> login (@RequestBody CustomerData customer) throws Exception{
        Customer response = loginService.login(customer);
        ResponseEntity<Customer> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;


    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<Customer> changePassword(@RequestBody CustomerData customer) throws Exception{
        return new ResponseEntity<>(loginService.changePassword(customer),HttpStatus.OK);
    }

}
