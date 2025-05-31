package com.hrishabh.quora.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseDTO {
    Long id;
    Date createdAt;
    Date updatedAt;
}
