package com.hrishabh.quora.repository;

import com.hrishabh.quora.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
