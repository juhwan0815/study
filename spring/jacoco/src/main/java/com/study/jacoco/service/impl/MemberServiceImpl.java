package com.study.jacoco.service.impl;

import com.study.jacoco.domain.Member;
import com.study.jacoco.dto.MemberCreateRequest;
import com.study.jacoco.dto.MemberResponse;
import com.study.jacoco.dto.MemberUpdateRequest;
import com.study.jacoco.repository.MemberRepository;
import com.study.jacoco.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberResponse create(MemberCreateRequest request) {
        Member member = Member.createMember(request.getName(), request.getAge());
        memberRepository.save(member);
        return MemberResponse.from(member);
    }

    @Override
    @Transactional
    public MemberResponse update(Long memberId, MemberUpdateRequest request) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException());
        findMember.update(request.getName(),request.getAge());
        return MemberResponse.from(findMember);
    }

    @Override
    @Transactional
    public void delete(Long memberId) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException());

        memberRepository.delete(findMember);
    }

    @Override
    public MemberResponse findById(Long memberId) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException());

        return MemberResponse.from(findMember);
    }

    @Override
    public List<MemberResponse> findAll() {
        List<Member> members = memberRepository.findAll();

        return members.stream()
                .map(member -> MemberResponse.from(member))
                .collect(Collectors.toList());
    }


}
