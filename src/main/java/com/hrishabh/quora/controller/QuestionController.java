package com.hrishabh.quora.controller;

import com.hrishabh.quora.dto.QuestionDTO;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.User;
import com.hrishabh.quora.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Create a new question from DTO
    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDTO questionDTO) {
        Question question = new Question();
        question.setTitle(questionDTO.getTitle());
        question.setContent(questionDTO.getContent());
        // stub user with just id, assuming your Question model has User user field
        User user = new User();
        user.setId(questionDTO.getUserId());
        question.setUser(user);

        Question created = questionService.createQuestion(question);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get question by ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        System.out.println("ID " + id);
        Optional<Question> questionOpt = questionService.getQuestionById(id);
        return questionOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all questions
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Get questions by user ID
    @GetMapping("/user/{userId}")
    public List<Question> getQuestionsByUserId(@PathVariable Long userId) {
        return questionService.getQuestionsByUserId(userId);
    }

    // Delete a question by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
