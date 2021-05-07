package com.example.club.controller;


import com.example.club.dto.NoteDto;
import com.example.club.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/")
    public ResponseEntity<Long> register(@RequestBody NoteDto noteDto){
        log.info("=============register=============");
        log.info("{}",noteDto);

        Long num = noteService.register(noteDto);

        return new ResponseEntity<>(num, HttpStatus.OK);
    }

    @GetMapping("/{num}")
    public ResponseEntity<NoteDto> read(@PathVariable("num") Long num){
        log.info("------------read-----------------");
        log.info("{}",num);

        return new ResponseEntity<>(noteService.get(num),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NoteDto>> getList(String email){
        log.info("-----------getList-----------");
        log.info(email);

        return new ResponseEntity<>(noteService.getAllWithWriter(email),HttpStatus.OK);
    }

    @DeleteMapping("/{num}")
    public ResponseEntity<String> remove(@PathVariable("num") Long num){
        log.info("---------remove-------------");
        log.info("{}",num);

        noteService.remove(num);

        return new ResponseEntity<>("removed",HttpStatus.OK);
    }

    @PutMapping("/{num}")
    public ResponseEntity<String> modify(@RequestBody NoteDto noteDto){
        log.info("----------modify-----------");
        log.info("{}",noteDto);

        noteService.modify(noteDto);

        return new ResponseEntity<>("modified",HttpStatus.OK);
    }


}
