package com.fse.shoppingapp.service;

import com.fse.shoppingapp.model.Customer;
import com.fse.shoppingapp.model.CustomerData;
import org.springframework.stereotype.Component;


public interface LoginService {

    public Customer registerCustomer(Customer customer);

    public Customer login (CustomerData customerData) throws Exception;

    public Customer changePassword(CustomerData customerData) throws Exception;
}
