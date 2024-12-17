package com.quiz.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.model.Question;
import com.quiz.app.repository.QuestionRepository;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question getRandomQuestion() {
        List<Question> allQuestions = questionRepository.findAll();
        if (allQuestions.isEmpty()) {
            throw new RuntimeException("No questions available.");
        }
        Random random = new Random();
        return allQuestions.get(random.nextInt(allQuestions.size()));
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}

