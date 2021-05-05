package com.example.mreview.controller;

import com.example.mreview.dto.MovieDto;
import com.example.mreview.dto.PageRequestDto;
import com.example.mreview.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/register")
    public String register(){
        return "/movie/register";
    }

    @PostMapping("/register")
    public String register(MovieDto movieDto, RedirectAttributes redirectAttributes){
        log.info("movieDto: " + movieDto);

        Long mno = movieService.register(movieDto);

        redirectAttributes.addFlashAttribute("msg",mno);

        return "redirect:/movie/list";
    }

    @GetMapping("/list")
    public String list(PageRequestDto pageRequestDto, Model model){
        log.info("pageRequestDto" + pageRequestDto);

        model.addAttribute("result",movieService.getList(pageRequestDto));

        return "/movie/list";
    }

    @GetMapping("/read")
    public String read(Long mno, @ModelAttribute("requestDTO") PageRequestDto requestDto,
                       Model model){
        log.info("mno:" + mno);

        MovieDto movieDto = movieService.getMovie(mno);

        model.addAttribute("dto",movieDto);

        return "/movie/read";
    }

}
