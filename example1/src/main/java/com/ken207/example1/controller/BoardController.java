package com.ken207.example1.controller;


import com.ken207.example1.domain.Board;
import com.ken207.example1.dto.BoardReqDTO;
import com.ken207.example1.dto.BoardResDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @PostMapping("/hello")
    public BoardResDTO postBaord(@RequestBody BoardReqDTO boardReqDto){
        return BoardResDTO.builder()
                .author(boardReqDto.getAuthor())
                .subject(boardReqDto.getSubject())
                .content(boardReqDto.getContent())
                .createdTime(LocalDateTime.now())
                .modifiedTime(LocalDateTime.now())
                .password(boardReqDto.getPassword())
                .delYn(false)
                .build();
    }

    @PutMapping("/update")
    public String adjustBoard(){
        return "";
    }

    @PutMapping("delete")
    public boolean deleteBoard(){
        return false;
    }
}
