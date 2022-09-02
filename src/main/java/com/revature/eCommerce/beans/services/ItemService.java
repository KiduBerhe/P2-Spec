package com.revature.eCommerce.beans.services;

import com.revature.eCommerce.beans.repositories.ItemRepository;
import com.revature.eCommerce.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){ return itemRepository.findAll();}

    public Optional<Item> getItemById(Integer id){
        return itemRepository.findById(id);
    }
    public void createItem(Item item){ itemRepository.save(item);}

    public void updateItem(Item item){ itemRepository.save(item);}

    public void deleteById(Integer id){ itemRepository.deleteById(id);}

}
