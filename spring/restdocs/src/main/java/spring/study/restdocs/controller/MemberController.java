package spring.study.restdocs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.study.restdocs.dto.member.MemberCreateRequest;
import spring.study.restdocs.dto.member.MemberResponse;
import spring.study.restdocs.service.MemberService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberResponse> createMember(@RequestBody MemberCreateRequest request){
        return ResponseEntity.ok(memberService.createMember(request));
    }
}
