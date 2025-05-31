package com.hrishabh.quora.controller;

import com.hrishabh.quora.dto.AnswerDTO;
import com.hrishabh.quora.models.Answer;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.User;
import com.hrishabh.quora.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    // Create or update an answer from AnswerDTO
    @PostMapping
    public ResponseEntity<Answer> saveAnswer(@RequestBody AnswerDTO answerDTO) {
        // Build Answer entity from DTO
        Answer answer = Answer.builder()
                .content(answerDTO.getContent())
                .user(User.builder().id(answerDTO.getUserId()).build()) // stub User with only id
                .question(Question.builder().id(answerDTO.getQuestionId()).build()) // stub Question with only id
                .build();

        Answer savedAnswer = answerService.saveAnswer(answer);
        return new ResponseEntity<>(savedAnswer, HttpStatus.CREATED);
    }

    // Rest remains same, you can keep them unchanged

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Optional<Answer> answerOpt = answerService.getAnswerById(id);
        return answerOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Answer>> getAnswersByQuestion(@PathVariable Long questionId) {
        Question question = Question.builder().id(questionId).build();
        List<Answer> answers = answerService.getAnswersByQuestion(question);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Answer>> getAnswersByUser(@PathVariable Long userId) {
        User user = User.builder().id(userId).build();
        List<Answer> answers = answerService.getAnswersByUser(user);
        return ResponseEntity.ok(answers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
