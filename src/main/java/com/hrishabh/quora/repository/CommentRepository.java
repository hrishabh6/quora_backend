package com.hrishabh.quora.repository;

import com.hrishabh.quora.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
