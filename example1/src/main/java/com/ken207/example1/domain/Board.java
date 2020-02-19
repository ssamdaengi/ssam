package com.ken207.example1.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "Board_Id")
    private long id;

    private  String author;
    private  String subject;
    private  String content;
    private  LocalDateTime createdTime;
    private  LocalDateTime modifiedTime;
    private  int hitCount;
    private boolean delYn;
    private String password;

    @Builder.Default
    @OneToMany(mappedBy = "comment")
    private List<Comment> commentlist = new ArrayList();

    public static Board postBoard(String author, String subject, String content, String password, boolean delYn){
        return Board.builder()
                .author("원선재")
                .subject("행복한 하루")
                .content("컵밥 맛있어~")
                .createdTime(LocalDateTime.now())
                .modifiedTime(LocalDateTime.now())
                .password(password)
                .delYn(false)
                .build();
    }

    public int readBoardById(){
        return this.hitCount++;
    }

    public void adjuestBoard(String subject, String content){
        this.subject = subject;
        this.content = content;
        this.createdTime = LocalDateTime.now();
        this.modifiedTime = LocalDateTime.now();
    }

    public void deleteBoard(){
        this.delYn = true;
    }
}
