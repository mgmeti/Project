package com.quiz.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.model.SessionStatistics;
import com.quiz.app.repository.SessionStatisticsRepository;

@Service
public class SessionStatisticsService {
    @Autowired
    private SessionStatisticsRepository sessionStatisticsRepository;

    public SessionStatistics getStatisticsBySessionId(Long sessionId) {
        return sessionStatisticsRepository.findBySessionId(sessionId);
    }
}

