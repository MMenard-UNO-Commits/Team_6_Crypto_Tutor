package com.crypto_tutor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crypto_tutor.models.Question;

/**
 * This is the interface for the Question Repository
 * @author Tommy Nelson
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
}