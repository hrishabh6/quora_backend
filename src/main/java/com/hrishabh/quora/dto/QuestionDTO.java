package com.hrishabh.quora.dto;

import com.hrishabh.quora.models.shared.BaseModel;
import lombok.Data;

@Data
public  class QuestionDTO  {
    Long id;
    private String title;
    private String content;
    private Long userId;
    private String username;
}
