package com.hrishabh.quora.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AnswerDTO extends BaseDTO {
    private String content;
    private Long userId;
    private Long questionId;
}
