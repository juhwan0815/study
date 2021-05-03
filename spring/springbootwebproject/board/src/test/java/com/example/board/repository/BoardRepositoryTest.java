package com.example.board.repository;

import com.example.board.entity.Board;
import com.example.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void insertBoard() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@aaa.com")
                    .build();

            Board board = Board.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer(member)
                    .build();

            boardRepository.save(board);
        });
    }

    @Test
    @Transactional
    void testRead1() {
        Optional<Board> result = boardRepository.findById(100L);

        Board board = result.get();
        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    void testReadWithWriter() {
        Object result = boardRepository.getBoardWithWriter(100L);

        Object[] arr = (Object[]) result;
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void testGetBoardWithReply() {
        List<Object[]> result = boardRepository.getBoardWithReply(100L);

        for (Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    void testWithReplyCount() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {
            Object[] arr = row;
            System.out.println(Arrays.toString(arr));
        });
    }

    @Test
    void testRead3() {
        Object result = boardRepository.getBoardByBno(100L);

        Object[] arr = (Object[]) result;
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void testSearch1() {
        boardRepository.search1();
    }

    @Test
    public void testSearchPage() {

        PageRequest pageable = PageRequest.of(0, 10, Sort.by("bno").descending()
                .and(Sort.by("title").ascending()));

        Page<Object[]> result = boardRepository.searchPage("t", "1", pageable);
    }

}