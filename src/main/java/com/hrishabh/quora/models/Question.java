package com.hrishabh.quora.models;

import com.hrishabh.quora.models.shared.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question extends BaseModel {

    @Column(nullable = false, length = 255)
    private String title;

    @Lob  // Large Object, suitable for long content
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
