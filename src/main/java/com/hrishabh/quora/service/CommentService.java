package com.hrishabh.quora.service;

import com.hrishabh.quora.models.Answer;
import com.hrishabh.quora.models.Comment;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.User;
import com.hrishabh.quora.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Create or update a comment
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Get comment by ID
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    // Get all comments by a user
    public List<Comment> getCommentsByAuthor(User author) {
        return commentRepository.findByAuthor(author);
    }

    // Get all comments on a question
    public List<Comment> getCommentsByQuestion(Question question) {
        return commentRepository.findByQuestion(question);
    }

    // Get all comments on an answer
    public List<Comment> getCommentsByAnswer(Answer answer) {
        return commentRepository.findByAnswer(answer);
    }

    // Get replies to a parent comment
    public List<Comment> getReplies(Comment parentComment) {
        return commentRepository.findByParentComment(parentComment);
    }

    // Delete a comment
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
