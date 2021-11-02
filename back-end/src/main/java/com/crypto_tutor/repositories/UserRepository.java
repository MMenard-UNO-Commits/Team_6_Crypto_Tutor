package com.crypto_tutor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto_tutor.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
