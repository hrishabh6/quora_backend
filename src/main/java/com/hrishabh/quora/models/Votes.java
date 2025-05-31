package com.hrishabh.quora.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "votes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "question_id"}),
                @UniqueConstraint(columnNames = {"user_id", "answer_id"}),
                @UniqueConstraint(columnNames = {"user_id", "comment_id"})
        }
)

public class Votes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User who voted
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Target question (optional)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    // Target answer (optional)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    // Target comment (optional)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    // Vote value: true for upvote, false for downvote
    @Column(nullable = false)
    private boolean upvote;

    // Timestamp if needed
    // @CreationTimestamp or @Temporal for date

}
