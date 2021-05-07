package com.example.bimovie.repository;

import com.example.bimovie.entity.Movie;
import com.example.bimovie.entity.Poster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void testInsert(){
        Movie movie = Movie.builder()
                .title("극한 직업")
                .build();

        movie.addPoster(Poster.builder().fname("극한직업포스터1.jpg").build());
        movie.addPoster(Poster.builder().fname("극한직업포스터2.jpg").build());

        movieRepository.save(movie);
    }

    @Test
    @Transactional
    @Commit
    public void testAddPoster(){
        Movie movie = movieRepository.getOne(1L);

        movie.addPoster(Poster.builder()
                .fname("극한직업포스터3.jpg")
                .build());

        movieRepository.save(movie);
    }

    @Test
    @Transactional
    @Commit
    public void testRemovePoster(){
        Movie movie = movieRepository.getOne(1L);

        movie.removePoster(2L);

        movieRepository.save(movie);
    }

    @Test
    void insertMovies(){
        IntStream.rangeClosed(10,100).forEach(i -> {
            Movie movie = Movie.builder()
                    .title("세계명작" + i)
                    .build();

            movie.addPoster(Poster.builder().fname("세계명작" + i + "포스터1.jpg").build());
            movie.addPoster(Poster.builder().fname("세계명작" + i + "포스터2.jpg").build());

            movieRepository.save(movie);
        });
    }

    @Test
    void testPaging1(){
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        Page<Movie> result = movieRepository.findAll(pageable);

        result.getContent().forEach(m -> {
            System.out.println(m.getMno());
            System.out.println(m.getTitle());
            System.out.println(m.getPosterList().size());

            System.out.println("-----------------------");
        });
    }

    @Test
    void testPaging2All(){
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        Page<Movie> result = movieRepository.findAll2(pageable);

        result.getContent().forEach(m -> {
            System.out.println(m.getMno());
            System.out.println(m.getTitle());
            System.out.println(m.getPosterList());
            System.out.println("---------------");
        });
    }

    @Test
    void testPaging3All(){
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        Page<Object[]> result = movieRepository.findALl3(pageable);

        result.getContent().forEach(arr -> {
            System.out.println(Arrays.toString(arr));
            System.out.println("------------------");
        });
    }


}