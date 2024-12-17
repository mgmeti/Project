package com.quiz.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.model.AppUser;
import com.quiz.app.model.Session;
import com.quiz.app.model.SessionStatistics;
import com.quiz.app.repository.SessionRepository;
import com.quiz.app.repository.SessionStatisticsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionStatisticsRepository sessionStatisticsRepository;

    public Session createSession(AppUser user) {
        Session session = new Session();
        session.setStartTime(LocalDateTime.now());
        session.setUser(user);
        Session savedSession = sessionRepository.save(session);

      
        SessionStatistics statistics = new SessionStatistics();
        statistics.setSession(savedSession);
        sessionStatisticsRepository.save(statistics);

        return savedSession;
    }

    public Optional<Session> getSessionId(Long sessionId) {
        return sessionRepository.findById(sessionId);
    }
    
    public List<Session> getSessionsByUserId(Long userId){
    	return sessionRepository.findByUserId(userId);
    }
}

