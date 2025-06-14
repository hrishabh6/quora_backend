package com.hrishabh.quora.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrishabh.quora.models.shared.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Answer extends BaseModel {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // Many answers can belong to one question
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // Many answers can be written by one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
