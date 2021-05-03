package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.dto.PageResultDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;
    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDto dto) {
        log.info("{}",dto);

        Board board = dtoToEntity(dto);
        repository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDto<BoardDto, Object[]> getList(PageRequestDto pageRequestDto) {
        log.info("{}",pageRequestDto);

        Function<Object[], BoardDto> fn = (en -> entityToDto((Board)en[0],(Member) en[1],(Long) en[2]));

//        Page<Object[]> result =
//                repository.getBoardWithReplyCount(pageRequestDto.getPageable(Sort.by("bno").descending()));
        Page<Object[]> result = repository.searchPage(
                pageRequestDto.getType(),
                pageRequestDto.getKeyword(),
                pageRequestDto.getPageable(Sort.by("bno").descending())
        );

        return new PageResultDto<>(result,fn);
    }

    @Override
    public void modify(BoardDto boardDto) {
        Board board = repository.findById(boardDto.getBno()).get();

        if(board != null){
            board.changeTitle(boardDto.getTitle());
            board.changeContent(boardDto.getContent());
        }

        repository.save(board);
    }

    @Override
    public BoardDto get(Long bno) {
        Object result = repository.getBoardByBno(bno);
        Object[] arr = (Object[]) result;
        return entityToDto((Board) arr[0],(Member) arr[1],(Long) arr[2]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno) {
        replyRepository.deleteByBno(bno);
        repository.deleteById(bno);
    }


}
