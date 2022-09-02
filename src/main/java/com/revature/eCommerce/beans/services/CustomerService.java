package com.revature.eCommerce.beans.services;

import com.revature.eCommerce.beans.repositories.CustomerRepository;
import com.revature.eCommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
   private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Integer customerId){
        return customerRepository.findById(customerId);
    }

    public void createCustomer(Customer customer) {
//        Optional<Customer> customerByEmail = customerRepository.findByEmail(customer.getEmail());
//        if (customerByEmail.isPresent()){
//            throw new IllegalStateException("Already Registered");
//        }
           customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }



    public void deleteCustomer(Integer customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("Customer with id" + customerId + "doesn't exists");
        }
        customerRepository.deleteById(customerId);
    }

}
