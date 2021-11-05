package com.crypto_tutor.repositories;

import com.crypto_tutor.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
