package com.hrishabh.quora.repository;

import com.hrishabh.quora.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
