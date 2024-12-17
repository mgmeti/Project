package com.quiz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.AnswerSubmission;

@Repository
public interface AnswerSubmissionRepository extends JpaRepository<AnswerSubmission, Long> {
    // Find all submissions for a specific session
    List<AnswerSubmission> findBySessionId(Long sessionId);
}