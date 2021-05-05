package com.example.mreview.service;

import com.example.mreview.dto.MovieDto;
import com.example.mreview.dto.MovieImageDto;
import com.example.mreview.dto.PageRequestDto;
import com.example.mreview.dto.PageResultDto;
import com.example.mreview.entity.Movie;
import com.example.mreview.entity.MovieImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface MovieService {

    Long register(MovieDto movieDto);

    PageResultDto<MovieDto,Object[]> getList(PageRequestDto pageRequestDto);

    MovieDto getMovie(Long mno);

    default MovieDto entitiesToDto(Movie movie,List<MovieImage> movieImages, Double avg,Long reviewCnt){
        MovieDto movieDto = MovieDto.builder()
                .mno(movie.getMno())
                .title(movie.getTitle())
                .regDate(movie.getRegDate())
                .modDate(movie.getModDate())
                .build();

        List<MovieImageDto> movieImageDtoList = movieImages.stream()
                .map(movieImage -> {
                    return MovieImageDto.builder()
                            .imgName(movieImage.getImgName())
                            .path(movieImage.getPath())
                            .uuid(movieImage.getUuid())
                            .build();
                }).collect(Collectors.toList());

        movieDto.setImageDTOList(movieImageDtoList);
        movieDto.setAvg(avg);
        movieDto.setReviewCnt(reviewCnt.intValue());

        return movieDto;
    }

    default Map<String,Object> dtoToEntity(MovieDto movieDto){
        Map<String,Object> entityMap = new HashMap<>();

        Movie movie = Movie.builder()
                .mno(movieDto.getMno())
                .title(movieDto.getTitle())
                .build();

        entityMap.put("movie",movie);

        List<MovieImageDto> imageDtoList = movieDto.getImageDTOList();

        if(imageDtoList != null && imageDtoList.size() > 0){
            List<MovieImage> movieImageList = imageDtoList.stream()
                    .map(movieImageDto -> {
                        MovieImage movieImage = MovieImage.builder()
                                .path(movieImageDto.getPath())
                                .imgName(movieImageDto.getImgName())
                                .uuid(movieImageDto.getUuid())
                                .movie(movie)
                                .build();

                        return movieImage;
                    }).collect(Collectors.toList());

            entityMap.put("imgList",movieImageList);
        }
        return entityMap;
    }
}
