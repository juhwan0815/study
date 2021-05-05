package com.example.mreview.service;

import com.example.mreview.dto.ReviewDto;
import com.example.mreview.entity.Movie;
import com.example.mreview.entity.Review;
import com.example.mreview.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewDto> getListOfMovie(Long mno) {
        Movie movie = Movie.builder()
                .mno(mno)
                .build();

        List<Review> result = reviewRepository.findByMovie(movie);

        return result.stream()
                .map(movieReview -> entityToDto(movieReview))
                .collect(Collectors.toList());
    }

    @Override
    public Long register(ReviewDto movieReviewDto) {
        Review movieReview = dtoToEntity(movieReviewDto);

        reviewRepository.save(movieReview);
        return movieReview.getReviewNum();
    }

    @Override
    public void modify(ReviewDto movieReviewDto) {
        Optional<Review> result = reviewRepository.findById(movieReviewDto.getReviewnum());

        if(result.isPresent()) {
            Review movieReview = result.get();
            movieReview.changeGrade(movieReview.getGrade());
            movieReview.changeText(movieReview.getText());

            reviewRepository.save(movieReview);
        }
    }

    @Override
    public void remove(Long reviewnum) {
        reviewRepository.deleteById(reviewnum);
    }
}
