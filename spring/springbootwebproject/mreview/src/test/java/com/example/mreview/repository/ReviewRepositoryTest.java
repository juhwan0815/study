package com.example.mreview.repository;

import com.example.mreview.entity.Member;
import com.example.mreview.entity.Movie;
import com.example.mreview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void insertMovieReviews(){
        IntStream.rangeClosed(1,200).forEach(i -> {
            Long mno = (long) (Math.random() * 100) + 1;

            Long mid = ((long) (Math.random() * 100) + 1);
            Member member = Member.builder()
                    .mid(mid)
                    .build();

            Review movieReview = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int) (Math.random() * 5) + 1)
                    .text("이 영화에 대한 느낌 ... " + i)
                    .build();

            reviewRepository.save(movieReview);
        });
    }

    @Test
    void testGetMovieReviews(){
        Movie movie = Movie.builder()
                .mno(92L)
                .build();

        List<Review> result = reviewRepository.findByMovie(movie);
        result.forEach(movieReview -> {
            System.out.println(movieReview.getReviewNum());
            System.out.println(movieReview.getGrade());
            System.out.println(movieReview.getText());
            System.out.println(movieReview.getMember().getEmail());
            System.out.println("--------------------------------");
        });
    }

}