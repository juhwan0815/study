package com.example.practicetest.controller;

import com.example.practicetest.domain.Member;
import com.example.practicetest.model.member.MemberResponse;
import com.example.practicetest.model.member.MemberSaveRequest;
import com.example.practicetest.model.member.MemberUpdateRequest;
import com.example.practicetest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity saveMember(@RequestBody MemberSaveRequest memberSaveRequest) {
        memberService.saveMember(memberSaveRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/members/{memberId}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long memberId,
                                                       @RequestBody MemberUpdateRequest memberUpdateRequest) {
        Member member = memberService.updateMember(memberId, memberUpdateRequest);

        return ResponseEntity.ok(new MemberResponse(member));
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberResponse> findMemberById(@PathVariable Long memberId){
        Member findMember = memberService.findMemberById(memberId);
        return ResponseEntity.ok(new MemberResponse(findMember));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> findMembers(){
        List<Member> members = memberService.findMembers();
        List<MemberResponse> memberResponseList = members.stream()
                .map(member -> new MemberResponse(member))
                .collect(Collectors.toList());

        return ResponseEntity.ok(memberResponseList);
    }


}
