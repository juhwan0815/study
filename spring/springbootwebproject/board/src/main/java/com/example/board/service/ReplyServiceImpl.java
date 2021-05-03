package com.example.board.service;

import com.example.board.dto.ReplyDto;
import com.example.board.entity.Board;
import com.example.board.entity.Reply;
import com.example.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyRepository replyRepository;

    @Override
    public Long register(ReplyDto replyDto) {
        Reply reply = dtoToEntity(replyDto);

        replyRepository.save(reply);

        return reply.getRno();
    }

    @Override
    public List<ReplyDto> getList(Long bno) {
        List<Reply> result = replyRepository
                .getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());

        return result.stream().map(reply -> entityToDto(reply))
                .collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDto replyDto) {
        Reply reply = dtoToEntity(replyDto);

        replyRepository.save(reply);
    }

    @Override
    public void remove(Long rno) {

        replyRepository.deleteById(rno);
    }
}
