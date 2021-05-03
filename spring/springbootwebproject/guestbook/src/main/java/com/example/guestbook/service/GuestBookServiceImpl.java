package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.entity.QGuestbook;
import com.example.guestbook.repository.GuestbookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuestBookServiceImpl implements GuestbookService{

    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDto dto) {

        log.info("DTO ------------");
        log.info("{}",dto);

        Guestbook entity = dtoToEntity(dto);

        repository.save(entity);

        log.info("{}",entity);

        return entity.getGno();
    }

    @Override
    public PageResultDto<GuestbookDto, Guestbook> getList(PageRequestDto requestDto) {
        Pageable pageable = requestDto.getPageable(Sort.by("gno").descending());

        BooleanBuilder booleanBuilder = getSearch(requestDto);

        Page<Guestbook> result = repository.findAll(booleanBuilder, pageable);

        Function<Guestbook, GuestbookDto> fn = (entity -> entityToDto(entity));

        return new PageResultDto<>(result,fn);
    }

    @Override
    public GuestbookDto read(Long gno) {
        Optional<Guestbook> result = repository.findById(gno);

        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    @Override
    public void remove(Long gno) {
        repository.deleteById(gno);
    }

    @Override
    public void modify(GuestbookDto dto) {
        Optional<Guestbook> result = repository.findById(dto.getGno());
        if(result.isPresent()){
            Guestbook entity = result.get();
            entity.changeTitle(dto.getTitle());
            entity.changeContent(dto.getContent());

            repository.save(entity);
        }
    }

    private BooleanBuilder getSearch(PageRequestDto requestDto){

        String type = requestDto.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QGuestbook qGuestbook = QGuestbook.guestbook;

        String keyword = requestDto.getKeyword();

        BooleanExpression expression = qGuestbook.gno.gt(0L);

        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0){
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("t")){
            conditionBuilder.or(qGuestbook.title.contains(keyword));
        }
        if(type.contains("c")){
            conditionBuilder.or(qGuestbook.content.contains(keyword));
        }
        if(type.contains("w")){
            conditionBuilder.or(qGuestbook.writer.contains(keyword));
        }

        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }
}
