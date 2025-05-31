package com.hrishabh.quora.service;

import com.hrishabh.quora.models.Answer;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.User;
import com.hrishabh.quora.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    // Create or update an answer
    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    // Get an answer by ID
    public Optional<Answer> getAnswerById(Long id) {
        return answerRepository.findById(id);
    }

    // Get all answers for a question
    public List<Answer> getAnswersByQuestion(Question question) {
        return answerRepository.findByQuestion(question);
    }

    // Get all answers by a user
    public List<Answer> getAnswersByUser(User user) {
        return answerRepository.findByUser(user);
    }

    // Delete an answer
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}
