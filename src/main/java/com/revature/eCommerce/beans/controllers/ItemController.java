package com.revature.eCommerce.beans.controllers;

import com.revature.eCommerce.beans.services.ItemService;
import com.revature.eCommerce.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/{itemId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Item getItemById(@PathVariable Integer itemId){
        Optional<Item> optionalItem = itemService.getItemById(itemId);
                return optionalItem.get();
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Item> getAllItems(){ return itemService.getAllItems();}

    @PostMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createItem(@RequestBody Item item){ itemService.createItem(item);}

    @PutMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateItem(@RequestBody Item item){ itemService.updateItem(item);}

    @DeleteMapping(value = "/{itemId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteItem(@PathVariable Integer itemId){ itemService.deleteById(itemId);}
}
