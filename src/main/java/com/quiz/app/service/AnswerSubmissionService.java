package com.quiz.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.model.AnswerSubmission;
import com.quiz.app.model.Question;
import com.quiz.app.model.Session;
import com.quiz.app.model.SessionStatistics;
import com.quiz.app.repository.AnswerSubmissionRepository;
import com.quiz.app.repository.SessionStatisticsRepository;

@Service
public class AnswerSubmissionService {
    @Autowired
    private AnswerSubmissionRepository answerSubmissionRepository;

    @Autowired
    private SessionStatisticsRepository sessionStatisticsRepository;

    public AnswerSubmission submitAnswer(Session session, Question question, String selectedAnswer) {
        boolean isCorrect = selectedAnswer.equalsIgnoreCase(question.getAnswer());

        AnswerSubmission submission = new AnswerSubmission();
        submission.setSession(session);
        submission.setQuestion(question);
        submission.setSelectedAnswer(selectedAnswer);
        submission.setCorrect(isCorrect);

        
        AnswerSubmission savedSubmission = answerSubmissionRepository.save(submission);

    
        SessionStatistics statistics = sessionStatisticsRepository.findBySessionId(session.getId());
        if (statistics != null) {
            statistics.setTotalAnswered(statistics.getTotalAnswered() + 1);
            if (isCorrect) {
                statistics.setCorrectAnswers(statistics.getCorrectAnswers() + 1);
            } else {
                statistics.setIncorrectAnswers(statistics.getIncorrectAnswers() + 1);
            }
            sessionStatisticsRepository.save(statistics);
        }

        return savedSubmission;
    }
}
