package com.revature.eCommerce.beans.controllers;

import com.revature.eCommerce.beans.services.CartService;
import com.revature.eCommerce.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {
    private CartService cartService;

    @Autowired
    public  CartController(CartService cartService){ this.cartService = cartService;}

    @GetMapping(value = "/{cartId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Cart getCartById(@PathVariable Integer cartId){
        Optional<Cart> optionalCart = cartService.getCartById(cartId);
        try{
            optionalCart.isPresent();
        }catch(Exception e){
            System.out.println(e);
        }
        return optionalCart.get();
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createCart(@RequestBody Cart cart){ cartService.createCart(cart);}

    @PutMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCart(@RequestBody Cart cart){ cartService.updateCart(cart);}

    @DeleteMapping(value = "/{cartId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCart(@PathVariable Integer cartId){ cartService.deleteById(cartId);}
}
