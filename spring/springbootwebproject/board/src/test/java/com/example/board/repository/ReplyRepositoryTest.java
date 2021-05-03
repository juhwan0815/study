package com.example.board.repository;

import com.example.board.entity.Board;
import com.example.board.entity.Reply;
import org.dom4j.tree.AbstractNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;


    @Test
    void insetReply(){
        IntStream.rangeClosed(1,300).forEach(i -> {
            long bno = (long)(Math.random() * 100) + 1;

            Board board = Board.builder()
                    .bno(bno)
                    .build();

            Reply reply = Reply.builder()
                    .text("Reply..." + i)
                    .board(board)
                    .replyer("guest")
                    .build();

            replyRepository.save(reply);
        });
    }

    @Test
    void readReply1(){
        Optional<Reply> result = replyRepository.findById(1L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }

    @Test
    void testListByBoard(){
        List<Reply> replyList
                = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(97L).build());

        replyList.forEach(reply -> System.out.println(reply));
    }
}