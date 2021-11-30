package com.crypto_tutor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crypto_tutor.models.Answer;

/**
 * repository for adding answers to database;
 * @author Tommy Nelson
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    
}
