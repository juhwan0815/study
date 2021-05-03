package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.entity.Guestbook;

public interface GuestbookService {

    Long register(GuestbookDto dto);

    PageResultDto<GuestbookDto, Guestbook> getList(PageRequestDto requestDto);

    GuestbookDto read(Long gno);

    void remove(Long gno);

    void modify(GuestbookDto dto);

    default Guestbook dtoToEntity(GuestbookDto dto){
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return entity;
    }

    default GuestbookDto entityToDto(Guestbook entity){
        GuestbookDto dto = GuestbookDto.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }


}
