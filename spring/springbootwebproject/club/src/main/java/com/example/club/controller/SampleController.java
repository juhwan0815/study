package com.example.club.controller;

import com.example.club.dto.ClubAuthMemberDto;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/sample")
public class SampleController {

    @PreAuthorize("permitAll()")
    @GetMapping("/all")
    public String exAll(){
        log.info("exAll..........");
        return "/sample/all";
    }

    @PreAuthorize("#clubAuthMember != null && #clubAuthMember.username eq 'user95@naver.com'")
    @GetMapping("/exOnly")
    public String exMemberOnly(@AuthenticationPrincipal ClubAuthMemberDto clubAuthMember){
        log.info("exMemberOnly.....");
        log.info("{}",clubAuthMember);

        return "/sample/admin";
    }

    @GetMapping("/member")
    public String exMember(@AuthenticationPrincipal ClubAuthMemberDto clubAuthMemberDto) {
        log.info("exMember.......");

        log.info("---------------");
        log.info("{}", clubAuthMemberDto);

        return "/sample/member";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String exAdmin(){
        log.info("exAdmin........");

        return "/sample/admin";
    }
}
