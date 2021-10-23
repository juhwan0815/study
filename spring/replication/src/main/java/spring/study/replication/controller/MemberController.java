package spring.study.replication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.replication.dto.MemberCreateRequest;
import spring.study.replication.dto.MemberResponse;
import spring.study.replication.dto.MemberUpdateRequest;
import spring.study.replication.service.MemberService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberResponse> create(@RequestBody MemberCreateRequest request) {
        return ResponseEntity.ok(memberService.createMember(request));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberResponse> update(@PathVariable Long memberId,
                                                       @RequestBody MemberUpdateRequest request) {
        return ResponseEntity.ok(memberService.updateMember(memberId, request));
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity<Void> delete(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberResponse> findById(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> findAll(){
        return ResponseEntity.ok(memberService.findAll());
    }

}