package com.revature.eCommerce.beans.services;

import com.revature.eCommerce.beans.repositories.CartRepository;
import com.revature.eCommerce.entities.Cart;
import com.revature.eCommerce.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts(){ return cartRepository.findAll();}

    public Optional<Cart> getCartById(Integer id){ return cartRepository.findById(id);}

    public void createCart(Cart cart){ cartRepository.save(cart);}

    public void updateCart(Cart cart){ cartRepository.save(cart);}

    public void deleteById(Integer id){ cartRepository.deleteById(id);}

}
