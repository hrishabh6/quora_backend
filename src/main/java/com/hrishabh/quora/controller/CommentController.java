package com.hrishabh.quora.controller;

import com.hrishabh.quora.dto.CommentDTO;
import com.hrishabh.quora.models.*;
import com.hrishabh.quora.service.CommentService;
import com.hrishabh.quora.service.UserService;
import com.hrishabh.quora.service.QuestionService;
import com.hrishabh.quora.service.AnswerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public CommentController(CommentService commentService,
                             UserService userService,
                             QuestionService questionService,
                             AnswerService answerService) {
        this.commentService = commentService;
        this.userService = userService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<?> saveComment(@RequestBody CommentDTO request) {
        Optional<User> authorOpt = userService.getUserById(request.getAuthorId());
        if (authorOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid authorId");
        }

        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setAuthor(authorOpt.get());

        // Set question if present
        if (request.getQuestionId() != null) {
            Optional<Question> questionOpt = questionService.getQuestionById(request.getQuestionId());
            if (questionOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid questionId");
            }
            comment.setQuestion(questionOpt.get());
        }

        // Set answer if present
        if (request.getAnswerId() != null) {
            Optional<Answer> answerOpt = answerService.getAnswerById(request.getAnswerId());
            if (answerOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid answerId");
            }
            comment.setAnswer(answerOpt.get());
        }

        // Set parent comment if present
        if (request.getParentCommentId() != null) {
            Optional<Comment> parentCommentOpt = commentService.getCommentById(request.getParentCommentId());
            if (parentCommentOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid parentCommentId");
            }
            comment.setParentComment(parentCommentOpt.get());
        }

        Comment saved = commentService.saveComment(comment);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> commentOpt = commentService.getCommentById(id);
        return commentOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get comments by author (user)
    @GetMapping("/author/{userId}")
    public ResponseEntity<List<Comment>> getCommentsByAuthor(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        List<Comment> comments = commentService.getCommentsByAuthor(user);
        return ResponseEntity.ok(comments);
    }

    // Get comments on a question
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Comment>> getCommentsByQuestion(@PathVariable Long questionId) {
        Question question = new Question();
        question.setId(questionId);
        List<Comment> comments = commentService.getCommentsByQuestion(question);
        return ResponseEntity.ok(comments);
    }

    // Get comments on an answer
    @GetMapping("/answer/{answerId}")
    public ResponseEntity<List<Comment>> getCommentsByAnswer(@PathVariable Long answerId) {
        Answer answer = new Answer();
        answer.setId(answerId);
        List<Comment> comments = commentService.getCommentsByAnswer(answer);
        return ResponseEntity.ok(comments);
    }

    // Get replies to a comment (nested comments)
    @GetMapping("/replies/{parentCommentId}")
    public ResponseEntity<List<Comment>> getReplies(@PathVariable Long parentCommentId) {
        Comment parent = new Comment();
        parent.setId(parentCommentId);
        List<Comment> replies = commentService.getReplies(parent);
        return ResponseEntity.ok(replies);
    }

    // Delete a comment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
