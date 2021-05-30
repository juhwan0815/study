package juhwan.study.javatest.member;

import juhwan.study.javatest.domain.Member;
import juhwan.study.javatest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId) throws MemberNotFoundException;

    void validate(Long id);

    void notify(Study study);
    void notify(Member member);
}
