package com.quiz.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quiz.app.model.AnswerSubmission;
import com.quiz.app.model.AppUser;
import com.quiz.app.model.Question;
import com.quiz.app.model.Session;
import com.quiz.app.model.SessionStatistics;
import com.quiz.app.service.AnswerSubmissionService;
import com.quiz.app.service.AppUserService;
import com.quiz.app.service.QuestionService;
import com.quiz.app.service.SessionService;
import com.quiz.app.service.SessionStatisticsService;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private AnswerSubmissionService answerSubmissionService;

    @Autowired
    private SessionStatisticsService sessionStatisticsService;

   
    @PostMapping("/start-session/{userId}")
    public ResponseEntity<Session> startNewSession(@PathVariable Long userId) {
        Optional<AppUser> user = appUserService.getUserById(userId);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        
       

        Session session = sessionService.createSession(user.get());
        return ResponseEntity.ok(session);
    }

   
    @GetMapping("/random-question")
    public ResponseEntity<Question> getRandomQuestion() {
        try {
            Question question = questionService.getRandomQuestion();
            return ResponseEntity.ok(question);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    
    @PostMapping("/submit-answer")
    public ResponseEntity<AnswerSubmission> submitAnswer(
            @RequestParam Long sessionId,
            @RequestParam Long questionId,
            @RequestParam String selectedAnswer) {
        Optional<Session> session = sessionService.getSessionId(sessionId).stream()
                .filter(s -> s.getId().equals(sessionId))
                .findFirst();
        
        if (session.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Question> question = questionService.getAllQuestions().stream()
                .filter(q -> q.getId().equals(questionId))
                .findFirst();

        if (question.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        AnswerSubmission submission = answerSubmissionService.submitAnswer(session.get(), question.get(), selectedAnswer);
        return ResponseEntity.ok(submission);
    }

  
    @GetMapping("/statistics/{userId}/session/{sessionId}")
    public ResponseEntity<List<SessionStatistics>> getUserStatistics(@PathVariable("userId") Long userId,@PathVariable("sessionId") Long sessionId) {
        List<Session> sessions = sessionService.getSessionsByUserId(userId);

        if (sessions.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        List<SessionStatistics> statistics = sessions.stream().filter(session -> session.getId() == sessionId)
                .map(session -> sessionStatisticsService.getStatisticsBySessionId(session.getId()))
                .toList();

        return ResponseEntity.ok(statistics);
    }
}
