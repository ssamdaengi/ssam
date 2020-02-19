package com.ken207.example1.repository;

import com.ken207.example1.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    //@Rollback(false)
    public void Board등록정상테스트(){
        //given
        Board requestData = Board.builder()
                .author("원선재")
                .content("내용")
                .createdTime(LocalDateTime.now())
                .subject("제목")
                .build();
        //when
        Board newBoard = boardRepository.save(requestData);

        //then
        assertEquals( "원선재", newBoard.getAuthor());
        assertEquals( "내용", newBoard.getContent());
        assertEquals( "제목", newBoard.getSubject());
        assertNotNull( newBoard.getId());
        assertNotNull( newBoard.getCreatedTime());
    }

    @Test
    //@Rollback(false)
    public void Board수정테스트(){
        //given
        Board requestData = Board.builder()
                .author("원선재")
                .content("내용")
                .createdTime(LocalDateTime.now())
                .subject("제목")
                .build();
        Board newBoard = boardRepository.save(requestData);

        //when
        newBoard.setAuthor("홍석춘");
        Board selectBoard = boardRepository.findById(newBoard.getId()).get();

        //then
        assertEquals( "원선재", newBoard.getAuthor());
        assertEquals( newBoard.getId(), selectBoard.getId());
    }

}