package com.crypto_tutor.repositories;



import com.crypto_tutor.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interface for the user repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
