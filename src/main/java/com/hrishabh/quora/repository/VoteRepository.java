package com.hrishabh.quora.repository;
import com.hrishabh.quora.models.Votes;
import com.hrishabh.quora.models.User;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.Answer;
import com.hrishabh.quora.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

public interface VoteRepository extends JpaRepository<Votes, Long> {

    // Find a vote by user and question (if any)
    Optional<Votes> findByUserAndQuestion(User user, Question question);

    // Find a vote by user and answer (if any)
    Optional<Votes> findByUserAndAnswer(User user, Answer answer);

    // Find a vote by user and comment (if any)
    Optional<Votes> findByUserAndComment(User user, Comment comment);

    // Find all votes by a user
    List<Votes> findByUser(User user);

    // Find all votes on a question
    List<Votes> findByQuestion(Question question);

    // Find all votes on an answer
    List<Votes> findByAnswer(Answer answer);

    // Find all votes on a comment
    List<Votes> findByComment(Comment comment);
}
