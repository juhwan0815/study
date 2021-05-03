package com.example.board.service;

import com.example.board.dto.ReplyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyServiceTest {

    @Autowired
    private ReplyService service;

    @Test
    void testGetList(){
        Long bno = 100L;

        List<ReplyDto> replyDtoList = service.getList(bno);

        replyDtoList.forEach(replyDto -> System.out.println(replyDto));
    }

}