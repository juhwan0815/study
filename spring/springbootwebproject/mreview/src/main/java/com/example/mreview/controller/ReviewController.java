package com.example.mreview.controller;

import com.example.mreview.dto.ReviewDto;
import com.example.mreview.service.ReviewService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{mno}/all")
    public ResponseEntity<List<ReviewDto>> getList(@PathVariable("mno") Long mno){

        log.info("---------List----------");
        log.info("Mno: " + mno);

        List<ReviewDto> reviewDtoList = reviewService.getListOfMovie(mno);
        return new ResponseEntity<>(reviewDtoList, HttpStatus.OK);
    }

    @PostMapping("/{mno}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDto reviewDto){
        log.info("-----------add MovieReview------------");
        log.info("reviewDto:" + reviewDto);

        Long reviewnum = reviewService.register(reviewDto);

        return new ResponseEntity<>(reviewnum,HttpStatus.OK);
    }

    @PutMapping("/{mno}/{reviewnum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewnum,
                                             @RequestBody ReviewDto reviewDto){
        log.info("-----------modify MovieReview----------" + reviewnum);
        log.info("reviewDto: " + reviewDto);

        reviewService.modify(reviewDto);

        return new ResponseEntity<>(reviewnum,HttpStatus.OK);
    }

    @DeleteMapping("/{mno}/{reviewnum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long reviewnum){
        log.info("----------modify removeReview----------");
        log.info("reviewnum: " + reviewnum);

        reviewService.remove(reviewnum);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }
}
