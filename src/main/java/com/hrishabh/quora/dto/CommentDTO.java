package com.hrishabh.quora.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String content;
    private Long authorId;          // user who wrote the comment
    private Long questionId;        // if comment on question
    private Long answerId;          // if comment on answer
    private Long parentCommentId;   // if it's a reply to another comment
}
