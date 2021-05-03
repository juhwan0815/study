package com.example.board.service;

import com.example.board.dto.ReplyDto;
import com.example.board.entity.Board;
import com.example.board.entity.Reply;

import java.util.List;

public interface ReplyService {

    Long register(ReplyDto replyDto);

    List<ReplyDto> getList(Long bno);

    void modify(ReplyDto replyDto);

    void remove(Long rno);

    default Reply dtoToEntity(ReplyDto replyDto){
        Board board = Board.builder()
                .bno(replyDto.getBno()).build();

        Reply reply = Reply.builder()
                .rno(replyDto.getRno())
                .text(replyDto.getText())
                .replyer(replyDto.getReplyer())
                .board(board)
                .build();

        return reply;
    }

    default ReplyDto entityToDto(Reply reply){
        ReplyDto dto = ReplyDto.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();

        return dto;
    }

}
