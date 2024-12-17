package com.quiz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Example: Find a random question (custom native SQL query if needed)
    // This assumes you use SQL RANDOM() to get random rows from the database
    Question findTopByOrderByIdDesc();

	List<Question> findAll();
}