package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookServiceTest {

    @Autowired
    private GuestbookService service;

    @Test
    void testRegister(){
        GuestbookDto guestbookDto = GuestbookDto.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDto));
    }

    @Test
    void testList(){
        PageRequestDto pageRequestDto = PageRequestDto.builder()
                .page(1)
                .size(10)
                .build();

        PageResultDto<GuestbookDto, Guestbook> resultDto = service.getList(pageRequestDto);

        System.out.println("PREV: " + resultDto.isPrev());
        System.out.println("NEXT: " + resultDto.isNext());
        System.out.println("TOTAL: " + resultDto.getTotalPage());
        System.out.println("----------------------------------");

        for (GuestbookDto guestbookDto : resultDto.getDtoList()) {
            System.out.println(guestbookDto);
        }

        System.out.println("==================================");
        resultDto.getPageList()
                .forEach(i -> System.out.println(i));

    }

    @Test
    public void testSearch(){
        PageRequestDto pageRequestDto = PageRequestDto.builder()
                .page(1)
                .size(10)
                .type("tc")
                .keyword("한글")
                .build();

        PageResultDto<GuestbookDto, Guestbook> resultDto = service.getList(pageRequestDto);

        System.out.println("PREV: " + resultDto.isPrev());
        System.out.println("NEXT: " + resultDto.isNext());
        System.out.println("TOTAL: " + resultDto.getTotalPage());

        System.out.println("----------------------------------");
        for (GuestbookDto guestbookDto : resultDto.getDtoList()) {
            System.out.println(guestbookDto);
        }

        System.out.println("==================================");
        resultDto.getPageList()
                .forEach(i -> System.out.println(i));
    }
}