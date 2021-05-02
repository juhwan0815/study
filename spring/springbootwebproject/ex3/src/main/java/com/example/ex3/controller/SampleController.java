package com.example.ex3.controller;


import com.example.ex3.dto.SampleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex1")
    public String ex1(){
        log.info("ex1..........");
        return "ex1";
    }

    @GetMapping("/ex2")
    public String exModel(Model model){

        List<SampleDto> list = IntStream.rangeClosed(1, 20).asLongStream()
                .mapToObj(i -> {
                    SampleDto dto = SampleDto.builder()
                            .sno(i)
                            .first("First..." + i)
                            .last("Last..." + i)
                            .regTime(LocalDateTime.now())
                            .build();
                    return dto;
                }).collect(Collectors.toList());

        model.addAttribute("list",list);

        return "ex2";
    }

    @GetMapping("/exLink")
    public String exLink(Model model){

        List<SampleDto> list = IntStream.rangeClosed(1, 20).asLongStream()
                .mapToObj(i -> {
                    SampleDto dto = SampleDto.builder()
                            .sno(i)
                            .first("First..." + i)
                            .last("Last..." + i)
                            .regTime(LocalDateTime.now())
                            .build();
                    return dto;
                }).collect(Collectors.toList());

        model.addAttribute("list",list);

        return "exLink";
    }


    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes){
        log.info("exInline.......");

        SampleDto dto = SampleDto.builder()
                .sno(100L)
                .first("First...100")
                .last("Last...100")
                .regTime(LocalDateTime.now())
                .build();

        redirectAttributes.addFlashAttribute("result","success");
        redirectAttributes.addFlashAttribute("dto",dto);

        return "redirect:/sample/ex3";
    }

    @GetMapping("/ex3")
    public String ex3(){
        log.info("ex3");
        return "ex3";
    }

    @GetMapping("/exLayout1")
    public String exLayout1(){
        log.info("exLayout..........");
        return "exLayout1";
    }

    @GetMapping("/exLayout2")
    public String exLayout2(){
        return "exLayout2";
    }

    @GetMapping("/exTemplate")
    public String exTemplate(){
        return "exTemplate";
    }

    @GetMapping("/exSidebar")
    public String exSidebar(){
        return "exSidebar";
    }
}
