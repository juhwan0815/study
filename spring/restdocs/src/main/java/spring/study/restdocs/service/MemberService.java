package spring.study.restdocs.service;

import spring.study.restdocs.domain.Member;
import spring.study.restdocs.dto.member.MemberCreateRequest;
import spring.study.restdocs.dto.member.MemberResponse;

public interface MemberService {

    public MemberResponse createMember(MemberCreateRequest request);
}
