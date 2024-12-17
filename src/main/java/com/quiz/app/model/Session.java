package com.quiz.app.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter 
@Getter
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
    
    @JsonIgnore
    @OneToMany(mappedBy = "session")
    private List<AnswerSubmission> answerSubmissions;

    @JsonIgnore
    @OneToOne(mappedBy = "session")
    private SessionStatistics statistics;

    
}

