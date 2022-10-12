package com.fse.shoppingapp.service;

import com.fse.shoppingapp.model.Customer;
import com.fse.shoppingapp.model.CustomerData;
import com.fse.shoppingapp.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public Customer login(CustomerData customer) throws Exception {
        Optional<Customer> repoOptionalCustomer = customerRepository.findById(customer.getEmail());
        if(repoOptionalCustomer.isPresent()){
            Customer repoCustomer = repoOptionalCustomer.get();
            if(repoCustomer.getPassword().equals(customer.getPassword())){
                return repoCustomer;
            }
            else{

                throw new Exception("Incorrect Password");
            }
        }
        else{
            throw new Exception("No user found with provided email");
        }

    }

    @Override
    public Customer changePassword(CustomerData customerData) throws Exception {
        Optional<Customer> repoOptionalCustomer = customerRepository.findById(customerData.getEmail());
        if(repoOptionalCustomer.isPresent()){
            Customer repoCustomer = repoOptionalCustomer.get();
            repoCustomer.setPassword(customerData.getPassword());
            return customerRepository.save(repoCustomer);
        }
        else{
            throw new Exception("No user found with provided email");
        }
    }
}
