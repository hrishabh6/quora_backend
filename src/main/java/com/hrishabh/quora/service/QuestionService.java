package com.hrishabh.quora.service;

import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Create a new question
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Get a question by ID
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    // Get all questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Get questions by user ID
    public List<Question> getQuestionsByUserId(Long userId) {
        return questionRepository.findByUserId(userId);
    }

    // Delete a question
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
