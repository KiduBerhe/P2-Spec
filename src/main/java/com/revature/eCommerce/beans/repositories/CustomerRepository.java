package com.revature.eCommerce.beans.repositories;


import com.revature.eCommerce.entities.Customer;
import com.revature.eCommerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
    //@Query("SELECT c FROM Customer c WHERE c.email = ?1")
    //Optional<Customer> findByEmail(String email);
}

