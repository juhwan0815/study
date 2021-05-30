package com.example.practicetest.service;

import com.example.practicetest.domain.Member;
import com.example.practicetest.exception.MemberException;
import com.example.practicetest.model.member.MemberSaveRequest;
import com.example.practicetest.model.member.MemberUpdateRequest;
import com.example.practicetest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long saveMember(MemberSaveRequest memberSaveRequest){
        if(memberRepository.findByEmail(memberSaveRequest.getEmail()).isPresent()){
            throw new MemberException("중복된 회원이 존재합니다.");
        }

        Member member = Member.createMember(memberSaveRequest.getEmail(),
                                            memberSaveRequest.getName(),
                                            memberSaveRequest.getPhoneNumber());

        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }


    @Transactional
    public Member updateMember(Long memberId,MemberUpdateRequest memberUpdateRequest) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException("존재하지 않는 회원입니다."));

        findMember.changeMember(memberUpdateRequest.getName(),
                                memberUpdateRequest.getPhoneNumber());
        return findMember;
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException("존재하지 않는 회원입니다."));

        findMember.deleteMember();
    }

    public Member findMemberById(Long memberId) {
        Member findMember = memberRepository.findWithOrderById(memberId)
                .orElseThrow(() -> new MemberException("존재하지 않는 회원입니다."));
        return findMember;
    }

    public List<Member> findMembers() {
        List<Member> members = memberRepository.findAllWithOrder();
        return members;
    }
}
