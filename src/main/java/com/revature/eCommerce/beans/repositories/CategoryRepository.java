package com.revature.eCommerce.beans.repositories;


import com.revature.eCommerce.entities.Category;
import com.revature.eCommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /*
    Extending the CrudRepository (by way of JpaRepository) should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
     */
}
