package com.example.guestbook.controller;

import com.example.guestbook.dto.GuestbookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @GetMapping("/")
    public String list(){
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")
    public String list(PageRequestDto pageRequestDto, Model model){
        log.info("list........." + pageRequestDto);
        model.addAttribute("result",service.getList(pageRequestDto));

        return "/guestbook/list";
    }

    @GetMapping("/register")
    public String register(){
        log.info("register get...");
        return "/guestbook/register";
    }

    @PostMapping("/register")
    public String registerPost(GuestbookDto dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);

        Long gno = service.register(dto);

        redirectAttributes.addFlashAttribute("msg",gno);

        return "redirect:/guestbook/list";
    }

    @GetMapping("/read")
    public String read(long gno, @ModelAttribute("requestDto") PageRequestDto requestDto,
                     Model model) {
        log.info("gno: " + gno);

        GuestbookDto dto = service.read(gno);

        model.addAttribute("dto",dto);

        return "/guestbook/read";
    }

    @GetMapping("/modify")
    public String modify(long gno, @ModelAttribute("requestDto") PageRequestDto requestDto,
                       Model model) {
        log.info("gno: " + gno);

        GuestbookDto dto = service.read(gno);

        model.addAttribute("dto",dto);

        return "/guestbook/modify";
    }


    @PostMapping("/modify")
    public String modify(GuestbookDto dto, @ModelAttribute("requestDto") PageRequestDto requestDto,
                         RedirectAttributes redirectAttributes){
        log.info("post modify...............");
        log.info("dto: " + dto);

        service.modify(dto);

        redirectAttributes.addAttribute("page",requestDto.getPage());
        redirectAttributes.addAttribute("type",requestDto.getType());
        redirectAttributes.addAttribute("keyword",requestDto.getKeyword());
        redirectAttributes.addAttribute("gno",dto.getGno());

        return "redirect:/guestbook/read";
    }

    @PostMapping("/remove")
    public String remove(long gno, RedirectAttributes redirectAttributes){
        log.info("gno: " + gno);

        service.remove(gno);

        redirectAttributes.addFlashAttribute("msg",gno);

        return "redirect:/guestbook/list";
    }


}
