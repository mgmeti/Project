package com.quiz.app.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "SESSION_STATISTICS")
public class SessionStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_answered", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int totalAnswered;

    @Column(name = "correct_answers", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int correctAnswers;

    @Column(name = "incorrect_answers", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int incorrectAnswers;

    @OneToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    
}
