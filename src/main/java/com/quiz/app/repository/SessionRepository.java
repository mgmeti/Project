package com.quiz.app.repository;

import java.util.List;
import com.quiz.app.model.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository  extends JpaRepository<Session, Long> {
	// Find all sessions for a specific user
    List<Session> findByUserId(Long userId);

}
