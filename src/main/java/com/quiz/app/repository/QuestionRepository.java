package com.quiz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
   
	List<Question> findAll();
}