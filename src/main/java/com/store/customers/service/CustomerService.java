package com.store.customers.service;

import com.store.customers.model.Customer;
import com.store.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer save (Customer customer){
        customer.setId(customerRepository.count()+1);
        return  customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    public Customer updateCustomer(Long id,Customer customer) {
        Customer customer1=getCustomerById(id);
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setAddress(customer.getAddress());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(customer1);
    }
}
