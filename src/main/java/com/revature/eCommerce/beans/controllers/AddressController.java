package com.revature.eCommerce.beans.controllers;

import com.revature.eCommerce.beans.services.AddressService;
import com.revature.eCommerce.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/{addressId}", method = RequestMethod.GET)
    public @ResponseBody Address getAddressById(@PathVariable Integer addressId){
        Optional<Address> optionalAddress = addressService.getAddressById((addressId));
        return optionalAddress.get();
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Address> getAllAddresses(){ return addressService.getAddresses();}

    @PostMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createAddress(@RequestBody Address address){ addressService.createAddress(address);}

    @PutMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateAddress(@RequestBody Address address){ addressService.updateAddress(address);}

    @DeleteMapping(value = "/{addressId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCustomer(@PathVariable(name = "addressId") Integer id) { addressService.deleteById(id);}

}
