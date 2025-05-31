package com.hrishabh.quora.repository;

import com.hrishabh.quora.models.Answer;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    // Find all answers for a given question
    List<Answer> findByQuestion(Question question);

    // Find all answers written by a specific user
    List<Answer> findByUser(User user);
}
