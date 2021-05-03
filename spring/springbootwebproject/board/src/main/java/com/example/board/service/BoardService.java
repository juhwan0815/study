package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.dto.PageResultDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import org.springframework.data.domain.PageRequest;

public interface BoardService {

    Long register(BoardDto dto);

    PageResultDto<BoardDto, Object[]> getList(PageRequestDto pageRequestDto);

    void modify(BoardDto boardDto);

    BoardDto get(Long bno);

    void removeWithReplies(Long bno);

    default Board dtoToEntity(BoardDto dto){
        Member member = Member.builder()
                .email(dto.getWriterEmail())
                .build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return board;
    }

    default BoardDto entityToDto(Board board, Member member, Long replyCount){
        BoardDto boardDto = BoardDto.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();

        return boardDto;
    }

}
