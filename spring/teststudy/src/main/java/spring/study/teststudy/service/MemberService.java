package spring.study.teststudy.service;

import spring.study.teststudy.domain.Member;
import spring.study.teststudy.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);
}