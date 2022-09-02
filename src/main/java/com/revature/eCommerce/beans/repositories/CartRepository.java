package com.revature.eCommerce.beans.repositories;


import com.revature.eCommerce.entities.Cart;
import com.revature.eCommerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
