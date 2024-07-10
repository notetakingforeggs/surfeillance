package com.northcoders.surfeillance.repository;

import com.northcoders.surfeillance.model.AppUser;
import com.northcoders.surfeillance.model.dto.AppUserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Integer> {

    AppUserDTO findByEmail(String email);
    // exists as a standard CrudRepository method
        // find a user by ID
        // existsByID
        // save

}
