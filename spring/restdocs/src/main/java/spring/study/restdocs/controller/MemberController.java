package spring.study.restdocs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.restdocs.domain.Member;

@RestController
public class MemberController {

    @GetMapping("/api/members/{memberId}")
    public Member getMemberPath(@PathVariable Long memberId){
        return new Member(memberId,"황주환");
    }

    @GetMapping("/api/members")
    public Member getMemberParam(@RequestParam Long memberId){
        return new Member(memberId,"황주환");
    }

    @GetMapping("/api/members/header")
    public ResponseEntity getMemberHeader(@RequestHeader("memberId") Long memberId) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("memberId", String.valueOf(memberId)).build();
    }

    @PostMapping("/api/members")
    public Member createMember(@RequestBody Member member){
        return member;
    }
}
