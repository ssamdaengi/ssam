package com.ken207.example1.domain;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    @Column(name="Comment_Id")
    private Long Id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id")
    private Board board;

}
