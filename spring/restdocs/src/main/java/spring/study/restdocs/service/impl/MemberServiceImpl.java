package spring.study.restdocs.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.study.restdocs.domain.Member;
import spring.study.restdocs.dto.member.MemberCreateRequest;
import spring.study.restdocs.dto.member.MemberResponse;
import spring.study.restdocs.repository.MemberRepository;
import spring.study.restdocs.service.MemberService;


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
}
