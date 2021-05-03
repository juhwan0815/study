package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.dto.PageResultDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void testRegister(){
        BoardDto dto = BoardDto.builder()
                .title("Test.")
                .content("Test...")
                .writerEmail("user55@aaa.com")
                .build();

        Long bno = boardService.register(dto);
    }

    @Test
    void testList(){
        PageRequestDto pageRequestDto = new PageRequestDto();

        PageResultDto<BoardDto, Object[]> result = boardService.getList(pageRequestDto);

        for (BoardDto boardDto : result.getDtoList()) {
            System.out.println(boardDto);
        }
    }

    @Test
    void testGet(){
        Long bno = 100L;

        BoardDto boardDto = boardService.get(bno);

        System.out.println(boardDto);
    }

    @Test
    void testRemove(){
        Long bno = 1L;

        boardService.removeWithReplies(bno);
    }

    @Test
    void testModify(){
        BoardDto boardDto = BoardDto.builder()
                .bno(2L)
                .title("제목 변경합니다.")
                .content("내용 변경합니다.")
                .build();

        boardService.modify(boardDto);
    }

}