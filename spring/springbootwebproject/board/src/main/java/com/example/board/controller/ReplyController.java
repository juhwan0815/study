package com.example.board.controller;

import com.example.board.dto.ReplyDto;
import com.example.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/board/{bno}")
    public ResponseEntity<List<ReplyDto>> getListByBoard(@PathVariable Long bno){

        log.info("bno: " + bno);

        return new ResponseEntity<>(replyService.getList(bno), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Long> register(@RequestBody ReplyDto replyDto){
        log.info("{}",replyDto);

        Long rno = replyService.register(replyDto);

        return new ResponseEntity<>(rno,HttpStatus.OK);
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable Long rno){
        log.info("RNO: " + rno);
        replyService.remove(rno);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ReplyDto replyDto){
        log.info("{}",replyDto);

        replyService.modify(replyDto);

        return new ResponseEntity<>("success",HttpStatus.OK);
    }



}
