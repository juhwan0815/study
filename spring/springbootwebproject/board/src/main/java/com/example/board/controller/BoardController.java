package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.service.BoardService;
import lombok.Getter;
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
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(PageRequestDto pageRequestDto, Model model){
        log.info("list........" + pageRequestDto);

        model.addAttribute("result",boardService.getList(pageRequestDto));

        return "/board/list";
    }

    @GetMapping("/register")
    public String register(){
        log.info("register get...");
        return "/board/register";
    }

    @PostMapping("/register")
    public String registerPost(BoardDto dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);

        Long bno = boardService.register(dto);

        log.info("BNO: " + bno);

        redirectAttributes.addFlashAttribute("msg",bno);

        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public String read(@ModelAttribute("requestDto") PageRequestDto pageRequestDto,Long bno,Model model){
        log.info("bno: " + bno);

        BoardDto boardDto = boardService.get(bno);

        log.info("{}",boardDto);

        model.addAttribute("dto",boardDto);

        return "/board/read";
    }

    @GetMapping("/modify")
    public String modify(@ModelAttribute("requestDto") PageRequestDto pageRequestDto,
                       Long bno, Model model){
        log.info("bno: " + bno);

        BoardDto boardDto = boardService.get(bno);

        log.info("{}",boardDto);

        model.addAttribute("dto",boardDto);

        return "/board/modify";
    }

    @PostMapping("/remove")
    public String remove(long bno,RedirectAttributes redirectAttributes){
        log.info("bno: " + bno);
        boardService.removeWithReplies(bno);

        redirectAttributes.addFlashAttribute("msg",bno);

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardDto dto, @ModelAttribute("requestDto") PageRequestDto requestDto,
                         RedirectAttributes redirectAttributes){
        log.info("post modify....................");
        log.info("dto: "  + dto);

        boardService.modify(dto);

        redirectAttributes.addAttribute("page",requestDto.getPage());
        redirectAttributes.addAttribute("type",requestDto.getType());
        redirectAttributes.addAttribute("keyword",requestDto.getKeyword());
        redirectAttributes.addAttribute("bno",dto.getBno());

        return "redirect:/board/read";
    }


}
