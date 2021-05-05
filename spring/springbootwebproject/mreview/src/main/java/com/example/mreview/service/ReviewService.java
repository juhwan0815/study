package com.example.mreview.service;

import com.example.mreview.dto.ReviewDto;
import com.example.mreview.entity.Member;
import com.example.mreview.entity.Movie;
import com.example.mreview.entity.Review;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> getListOfMovie(Long mno);

    Long register(ReviewDto movieReviewDto);

    void modify(ReviewDto movieReviewDto);

    void remove(Long reviewnum);

    default Review dtoToEntity(ReviewDto movieReviewDto){
        Review movieReview = Review.builder()
                .reviewNum(movieReviewDto.getReviewnum())
                .movie(Movie.builder()
                        .mno(movieReviewDto.getMno()).build())
                .member(Member.builder()
                        .mid(movieReviewDto.getMid()).build())
                .grade(movieReviewDto.getGrade())
                .text(movieReviewDto.getText())
                .build();

        return movieReview;
    }

    default ReviewDto entityToDto(Review movieReview){
        ReviewDto movieReviewDto = ReviewDto.builder()
                .reviewnum(movieReview.getReviewNum())
                .mno(movieReview.getMovie().getMno())
                .mid(movieReview.getMember().getMid())
                .nickname(movieReview.getMember().getNickName())
                .email(movieReview.getMember().getEmail())
                .grade(movieReview.getGrade())
                .text(movieReview.getText())
                .regDate(movieReview.getRegDate())
                .modDate(movieReview.getModDate())
                .build();

        return movieReviewDto;
    }
}
