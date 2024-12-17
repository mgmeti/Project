package com.quiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.SessionStatistics;

@Repository
public interface SessionStatisticsRepository extends JpaRepository<SessionStatistics, Long> {
    // Find statistics for a specific session
    SessionStatistics findBySessionId(Long sessionId);
}
