package com.ken207.example1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class BoardResDTO {
    private long id;
    private  String author;
    private  String subject;
    private  String content;
    private LocalDateTime createdTime;
    private  LocalDateTime modifiedTime;
    private  int hitCount;
    private boolean delYn;
    private String password;



}
