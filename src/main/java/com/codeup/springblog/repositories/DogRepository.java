package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Dogs;
import org.springframework.data.jpa.repository.JpaRepository;

//Dos is the reference type of the entity to CRUD
//Long is the reference type for the primary key of dogs
public interface DogRepository extends JpaRepository<Dogs, Long> {

    //search method
    Dogs findByNameIgnoreCase(String name);

}
