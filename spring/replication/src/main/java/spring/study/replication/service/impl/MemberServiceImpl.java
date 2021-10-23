package spring.study.replication.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.study.replication.domain.Member;
import spring.study.replication.dto.MemberCreateRequest;
import spring.study.replication.dto.MemberResponse;
import spring.study.replication.dto.MemberUpdateRequest;
import spring.study.replication.repository.MemberRepository;
import spring.study.replication.service.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberResponse createMember(MemberCreateRequest request) {
        Member member = Member.createMember(request.getName(), request.getAge());
        memberRepository.save(member);
        return MemberResponse.from(member);
    }

    @Override
    @Transactional
    public MemberResponse updateMember(Long memberId, MemberUpdateRequest request) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException());

        findMember.update(request.getName(),request.getAge());
        return MemberResponse.from(findMember);
    }

    @Override
    @Transactional
    public void deleteMember(Long memberId) {
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
        List<Member> findMembers = memberRepository.findAll();

        return findMembers.stream()
                .map(findMember -> MemberResponse.from(findMember))
                .collect(Collectors.toList());
    }


}
