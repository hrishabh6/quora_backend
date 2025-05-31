package com.hrishabh.quora.repository;

import com.hrishabh.quora.models.Answer;
import com.hrishabh.quora.models.Comment;
import com.hrishabh.quora.models.Question;
import com.hrishabh.quora.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Find all comments by author
    List<Comment> findByAuthor(User author);

    // Find all comments on a question
    List<Comment> findByQuestion(Question question);

    // Find all comments on an answer
    List<Comment> findByAnswer(Answer answer);

    // Find all replies to a parent comment
    List<Comment> findByParentComment(Comment parentComment);
}
